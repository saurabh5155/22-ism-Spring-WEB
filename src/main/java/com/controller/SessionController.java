package com.controller;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {
	
	
	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(UserBean userBean,Model model) {
		
//		UserBean userBean = new UserBean();
		model.addAttribute("userBean",userBean);
		return "Signup";
	}

	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("userBean") @Valid UserBean userBean, BindingResult result,Model model) {

		System.out.println("SessionController -> saveUser()");
//		System.out.println("Result ->"+result);

		if (result.hasErrors()) {
			model.addAttribute("userBean",userBean);	
			return "Signup";
		} else {
			System.out.println("FirstName :" + userBean.getFirstName());
			System.out.println("LastName :" + userBean.getLastName());
			System.out.println("email :" + userBean.getEmail());
			System.out.println("password :" + userBean.getPassword());
			System.out.println("Gender :" +userBean.getGender());
			
			userBean.setUserType("customer");
			userDao.addUser(userBean);
			model.addAttribute("msg","Signup Done.........");
			
			return "Login";
		}

	}


}
