package com.gyn;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper ;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gyn.bean.User;
public class Day03 {
	public static void main(String[] args) {
		//addUser();
		//updateUser();
		//deleteUser();
		//findUserById1();
		findAllUser();
		
	}
	//添加
	private static void addUser(){
		JdbcTemplate jt=new JdbcTemplate(JDBCUtils1.getDataSource());
		String sql ="insert into person(id,name,username,password,age)values(?,?,?,?,?)";
		int update1=jt.update(sql,1,"李白","per1","1235",22);
		int update2=jt.update(sql,2,"张飞","per2","1235",21);
		int update3=jt.update(sql,3,"妲己","per3","1235",20);
		int update4=jt.update(sql,4,"鲁班","per4","1235",25);
		int update5=jt.update(sql,5,"蔡文姬","per5","1235",26);
		System.out.println(update3);
	}
	//修改
		private static void updateUser(){
			JdbcTemplate jt=new JdbcTemplate(JDBCUtils1.getDataSource());
			int update=jt.update("update person set name=?,age=? where id=?","伽罗",23,1);
			System.out.println(update);
		}
		//删除
		private static void deleteUser(){
			JdbcTemplate jt=new JdbcTemplate(JDBCUtils1.getDataSource());
			int update=jt.update("delete from person where name=?","张飞");
			System.out.println(update);
		}
		//查询单个
		private static void findUserById1(){
			JdbcTemplate jt=new JdbcTemplate(JDBCUtils1.getDataSource());
			User user=jt.queryForObject(" select * from person where id=?",new BeanPropertyRowMapper<> (User.class),3);
			System.out.println(user);
		}
		 //查询所有
		private static void findAllUser() {
			//查询
		     JdbcTemplate jt =new JdbcTemplate (JDBCUtils1. getDataSource());
		     String sql = " select * from person";
		     List<User> list = jt. query(sql, new BeanPropertyRowMapper<User> (User.class));
	       	 for (User user : list) {
		        System. out. println(user);

		     }

		}
}
