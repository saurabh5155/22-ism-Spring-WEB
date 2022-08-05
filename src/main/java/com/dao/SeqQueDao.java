package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	public List<SecQueBean> getQueById(int userId) {
		return stmt.query("select * from users u inner join security_que s on u.userid = s.userid where u.userid =?",
				new BeanPropertyRowMapper<SecQueBean>(SecQueBean.class), userId);
	}
}
