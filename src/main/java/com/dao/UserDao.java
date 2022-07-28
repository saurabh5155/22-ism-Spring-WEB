package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	public List<UserBean> listUser() {
		List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));

		return users;
	}

	public void deleteUser(int userId) {
		stmt.update("delete from users where userid =?", userId);
	}

	public UserBean viewUser(int userId) {
		System.out.println(userId);
		UserBean userBean = stmt.queryForObject("select * from users where userid =?",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { userId });

		return userBean;
	}

	public void updateUser(UserBean userBean) {
		stmt.update("update users set firstname =?,lastname=?,gender=?,email=?,password=? where userid=?",
				userBean.getFirstName(), userBean.getLastName(), userBean.getGender(), userBean.getEmail(),
				userBean.getPassword(), userBean.getUserId());
	}

	public UserBean authenticate(LoginBean loginBean) {
		UserBean userBean = null;
		System.out.println(loginBean.getEmail());
		System.out.println(loginBean.getPassword());
		try {
			userBean = stmt.queryForObject("select * from users where email = ? and password = ? ",
					new BeanPropertyRowMapper<UserBean>(UserBean.class),
					new Object[] { loginBean.getEmail(), loginBean.getPassword() });
		} catch (Exception e) {
			System.out.println("Exception in UserDao -> login");
			e.printStackTrace();
		}
		System.out.println(userBean);
		return userBean;
	}

}
