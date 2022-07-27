package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean userBean) {
		stmt.update("insert into users (firstname,lastname,gender,email,password,usertype) values (?,?,?,?,?,?)",
				userBean.getFirstName(), userBean.getLastName(), userBean.getGender(), userBean.getEmail(),
				userBean.getPassword(), userBean.getUserType());
	}
}
