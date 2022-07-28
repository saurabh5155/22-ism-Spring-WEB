package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProfileBean;

@Repository
public class ProfileDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public void addProfileImg(ProfileBean profileBean ) {
		stmt.update("insert into profiles (img_url,userid,is_active) values (?,?,?)",profileBean.getImgUrl(),profileBean.getUserId(),profileBean.isActive());
	}
}
