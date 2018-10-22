package com.quark.atom.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.quark.atom.messaging.InventoryFileSink;
import com.quark.atom.messaging.InventoryFileSourceChannel;
import com.univocity.parsers.common.processor.ColumnProcessor;
import com.univocity.parsers.common.processor.ConcurrentRowProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryDataService {

	@Value("${file.dir.invdata}")
	private String inventoryFileDir;
	
	@Autowired
	private InventoryFileSourceChannel inventoryFileSourceChannel;
	
	public File storeFile(MultipartFile file) {
		try {
			Path targetPath = Paths.get(inventoryFileDir).resolve(file.getOriginalFilename());
			Files.copy(file.getInputStream(), targetPath);
			return targetPath.toFile();
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	} 
	
	public boolean sendProcessInventoryFileMsg(File file) {
		log.info("Sending message to process inventory file: {}", file.getAbsolutePath());
		return inventoryFileSourceChannel.invFileOutput().send(MessageBuilder.withPayload(file.getAbsolutePath())
                .build());
	}
	
	@StreamListener(InventoryFileSink.INPUT)
    public void listen(String filePath) {
        log.info(filePath + " received from messaging");
        CsvParserSettings parserSettings = new CsvParserSettings();
        // To get the values of all columns, use a column processor
		ColumnProcessor rowProcessor = new ColumnProcessor();
		parserSettings.setProcessor(rowProcessor);	
		//Parallel processing
		parserSettings.setProcessor(new ConcurrentRowProcessor(rowProcessor));
		
		CsvParser csvParser = new CsvParser(parserSettings);
		
		// Parse file 
		csvParser.parse(getReader(filePath));
		
		//Finally, we can get the column values:
		Map<String, List<String>> fileDataMap = new TreeMap<String, List<String>>(rowProcessor.getColumnValuesAsMapOfNames());
		log.info("Inventory file data map: {}", fileDataMap);
		
    }
	
	public static Reader getReader(String filePath) {
		try {
			return new InputStreamReader(new FileInputStream(filePath));
		} catch (Exception e) {
			throw new IllegalStateException("Unable to read input", e);
		}
	}
}
