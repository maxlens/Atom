package com.quark.atom.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.quark.atom.messaging.InventoryFileSink;
import com.quark.atom.messaging.InventoryFileSourceChannel;

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
    }
}
