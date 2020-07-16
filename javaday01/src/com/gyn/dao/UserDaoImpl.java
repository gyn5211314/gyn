package com.gyn.dao;

import java.util.List;

import com.gyn.bean.User;
import com.gyn.JDBCUtils1;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
	JdbcTemplate jt=new JdbcTemplate(JDBCUtils1.getDataSource());
	@Override
	public List<User> findAllUser(){
		String sql="select * from student";
		jt.query(sql,new BeanPropertyRowMapper<User>(User.class));
		return null;
	}

}
