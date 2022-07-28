package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.ProfileBean;
import com.bean.UserBean;
import com.dao.ProfileDao;
import com.dao.UserDao;
import com.service.FileUploadService;

@Controller
public class ProfileController {

	@Autowired
	UserDao userDao;

	@Autowired
	ProfileDao profileDao;

	@Autowired
	FileUploadService fileUploadService;

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

		try {

			fileUploadService.imgUpload(file, userId);
			ProfileBean profileBean = new ProfileBean();
			profileBean.setUserId(userId);
			profileBean.setImgUrl("resources/img/" + userId + "/" + file.getOriginalFilename());
			profileBean.setActive(true);

			profileDao.addProfileImg(profileBean);

		} catch (Exception e) {
			System.out.println("UserController -> saveProfile()");
			e.printStackTrace();
		}

		return "Home";
	}

	@GetMapping("/listProfile")
	public String listProfile(HttpSession session,Model model) {
		
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		int userId = userBean.getUserId();
		List<ProfileBean> profile =profileDao.listProfileById(userId);
		model.addAttribute("profile",profile);
		return "ListProfile";
	}
}
