package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.SecQueBean;

@Repository
public class SeqQueDao {

	@Autowired
	JdbcTemplate stmt;

	public void addSecQue(SecQueBean secQueBean) {
		stmt.update("insert into security_que (que,ans,userid) values (?,?,?)", secQueBean.getQue(),
				secQueBean.getAns(), secQueBean.getUserId());
	}
}
