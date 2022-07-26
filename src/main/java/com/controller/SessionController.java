package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.UserBean;

@Controller
public class SessionController {
	
	@RequestMapping(value = "/signup",method = RequestMethod.GET)
	public String signup() {
		return "Signup";
	}
	
	@RequestMapping(value = "saveUser",method = RequestMethod.POST)
	public String saveUser(UserBean userBean) {
		System.out.println("SessionController -> saveUser()");
		System.out.println("FirstName :"+userBean.getFirstName());
		System.out.println("LastName :"+userBean.getLastName());
		System.out.println("email :"+userBean.getEmail());
		System.out.println("password :"+userBean.getPassword());
		
		return "Login";
	}
}
