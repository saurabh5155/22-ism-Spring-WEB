package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.SecQueBean;
import com.bean.UserBean;
import com.dao.SeqQueDao;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@Autowired
	SeqQueDao seqQueDao;

	@GetMapping("/listUser")
	public String listUser(Model model) {
		List<UserBean> users = userDao.listUser();
		model.addAttribute("users", users);
		return "ListUsers";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId) {
		userDao.deleteUser(userId);

//		List<UserBean> users = userDao.listUser();
//		model.addAttribute("users",users);
//		return "ListUsers";

		return "redirect:listUser";
	}

	@GetMapping("/viewUser")
	public String viewUser(@RequestParam("userId") int userId, Model model) {
		UserBean userBean = userDao.viewUser(userId);
		model.addAttribute("userBean", userBean);
		return "ViewUser";
	}

	@GetMapping("/editUser")
	public String editUser(@RequestParam("userId") int userId, Model model) {

		UserBean userBean = userDao.viewUser(userId);
		model.addAttribute("userBean", userBean);
		return "EditUser";

	}

	@PostMapping("/updateUser")
	public String updateUser(@Valid UserBean userBean) {
		userDao.updateUser(userBean);
		return "redirect:listUser";
	}

	@GetMapping("/secQue")
	public String secQue(Model model,HttpSession session) {
		UserBean userBean =(UserBean) session.getAttribute("userBean");
		List<SecQueBean> secQueBean=	seqQueDao.getQueById(userBean.getUserId());
		model.addAttribute("secQueBean",secQueBean);
		return "SelectSecQue";
	}

	@PostMapping("/secQue")
	public String secQue1(SecQueBean secQueBean, HttpSession session) {
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		secQueBean.setUserId(userBean.getUserId());
		seqQueDao.addSecQue(secQueBean);
		return "redirect:/secQue";
	}

}
