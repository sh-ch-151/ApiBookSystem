package com.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.helper.FileHelperUpload;

@RestController
public class FileUploadController
{
	@Autowired
	private FileHelperUpload helper;
	
	@GetMapping("upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
		try
		{
			if(file.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is empty");
			}
			if(!file.getContentType().equals("image/jpeg"))
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg file allowed");
			}
			boolean upload = helper.upload(file);
			if(upload)
			{
				return ResponseEntity.ok("Successfully uploaded");
			}
		}
		catch(Exception e)
		{
			
		}
		
		return ResponseEntity.ok("working");
	}
}
