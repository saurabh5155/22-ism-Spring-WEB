package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.ProfileBean;
import com.bean.UserBean;
import com.dao.ProfileDao;
import com.dao.UserDao;

@Controller
public class ProfileController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProfileDao profileDao;
	
	
	@GetMapping("/addProfile")
	public String addProfile() {
		return "AddProfile";
	}

	@PostMapping("/saveProfile")
	public String saveProfile(@RequestParam("profile") MultipartFile file, HttpSession session) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

		UserBean userBean = (UserBean) session.getAttribute("userBean");
		int userId = userBean.getUserId();

		String mainPath = "F:\\JAVA ISM\\Spring\\22-ism-Spring-WEB\\src\\main\\webapp\\resources\\img";
		
		File folder = new File(mainPath,userId+"");
		folder.mkdir();
		
		File file1 = new File(folder, file.getOriginalFilename());
	
		try {
			byte b[] = file.getBytes();

			FileOutputStream fos = new FileOutputStream(file1);
			fos.write(b);
			fos.close();
			
			ProfileBean profileBean = new ProfileBean();
			profileBean.setUserId(userId);
			profileBean.setImgUrl("resources/img/"+userId+"/"+file.getOriginalFilename());
			profileBean.setActive(true);
			
			profileDao.addProfileImg(profileBean);

		} catch (IOException e) {
			System.out.println("UserController -> saveProfile()");
			e.printStackTrace();
		}
		
		return "Home";
	}
}
