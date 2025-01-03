package com.api.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelperUpload
{
	public final String UPLOAD_FILE = "C:\\Users\\SD-ShwetaC\\Documents\\Eclipse\\SpringMvcNewApiBook\\src\\main\\resources\\static\\image";
	
	public boolean upload(MultipartFile file)
	{
		boolean upload = false;
		try
		{
//			InputStream is = file.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			
//			FileOutputStream fos = new FileOutputStream(UPLOAD_FILE+File.separator+file.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_FILE+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			upload = true;
		}
		catch(Exception e)
		{
			
		}
		return upload;
	}
}
