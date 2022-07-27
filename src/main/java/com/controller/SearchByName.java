package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.SearchByNameBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SearchByName {

	@Autowired
	UserDao userDao;

	@GetMapping("/searchByName")
	public String searchByName(SearchByNameBean searchByNameBean, Model model) {
		model.addAttribute("searchByNameBean", searchByNameBean);
		return "SearchUserByName";
	}

	@SuppressWarnings("null")
	@PostMapping("/searchUserByName")
	public String searchUserByName(@Valid SearchByNameBean searchByNameBean, BindingResult result, Model model) {
		List<UserBean> getAllUsers = userDao.listUser();

		List<UserBean> users = null;
		if (result.hasErrors()) {
			return "SearchUserByName";
		} else {
			for (int j = 0; j < getAllUsers.size(); j++) {

				if (getAllUsers.get(j).getFirstName().contains(searchByNameBean.getFirstName())) {
					getAllUsers.get(j).getFirstName();
					getAllUsers.get(j).getLastName();
					getAllUsers.get(j).getEmail();
					getAllUsers.get(j).getGender();
					getAllUsers.get(j).getUserType();
					users.add((UserBean) getAllUsers);
				}
			}

			model.addAttribute("users", users);
			return "redirect:/listUser";

		}
	}
}
