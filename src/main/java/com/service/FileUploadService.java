package com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	public void imgUpload(MultipartFile file, int userId) {

		try {
			String mainPath = "F:\\JAVA ISM\\Spring\\22-ism-Spring-WEB\\src\\main\\webapp\\resources\\img";

			File folder = new File(mainPath, userId + "");
			folder.mkdir();

			File file1 = new File(folder, file.getOriginalFilename());
			
			byte b[] = file.getBytes();

			FileOutputStream fos = new FileOutputStream(file1);
			fos.write(b);
			fos.close();
		} catch (IOException e) {
			System.out.println("FileUploadService -> imgUpload()");
			e.printStackTrace();
		}
	}
}
