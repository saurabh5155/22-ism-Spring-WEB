package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class ListUserController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/listUser")
	public String listUser(Model model) {
		List<UserBean> users = userDao.listUser();
		model.addAttribute("users",users);
		return "ListUsers";
	}
}