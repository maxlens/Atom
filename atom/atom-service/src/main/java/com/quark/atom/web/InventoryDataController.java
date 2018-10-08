package com.quark.atom.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.quark.atom.service.InventoryDataService;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryDataController {

	@Autowired
	private InventoryDataService inventoryDataService;
	
	@PostMapping("/upload")
    public String uploadInventoryDataFile(@RequestParam("invFile") MultipartFile file) {
		//store
		File invFile = inventoryDataService.storeFile(file);
		//send msg
		inventoryDataService.sendProcessInventoryFileMsg(invFile);
		
        return "success";
    }
}
