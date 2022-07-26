package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public String saveUser(@Valid UserBean userBean,BindingResult result) {
		
		System.out.println("SessionController -> saveUser()");
//		System.out.println("Result ->"+result);
		
		if(result.hasErrors()) {
			return "Signup";
		}else {
			System.out.println("FirstName :"+userBean.getFirstName());
			System.out.println("LastName :"+userBean.getLastName());
			System.out.println("email :"+userBean.getEmail());
			System.out.println("password :"+userBean.getPassword());
			
			return "Login";			
		}
		
	}
}
