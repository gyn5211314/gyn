package com.gyn;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper ;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gyn.bean.User;
import com.gyn.dao.UserDao;
import com.gyn.dao.UserDaoImpl;
import com.gyn.JDBCUtils1;
public class JDBCUtils {
	public static void main(String[] args) {
		//addUser();
		//updateUser();
		findAllUser();
	}
	//添加方法 预编译
	private static void addUser(){
		JdbcTemplate jt=new JdbcTemplate(JDBCUtils1.getDataSource());
		String sql ="insert into person(id,name,username,password,age,describe,height)values(?,?,?,?,?,?,?)";
		//jt.insert(sql);
		int update1=jt.update(sql,1,"李白","per1","1235",22,"刺客",166);
		//int update2=jt.update(sql,2,"张飞","per2",1235,21,"战士",166);
		//int update3=jt.update(sql,3,"妲己","per3",1235,20,"法师",166);
		//int update4=jt.update(sql,4,"鲁班","per4",1235,25,"输出",166);
		//int update5=jt.update(sql,5,"蔡文姬","per5",1235,26,"辅助",166);
		System.out.println(update1);
	}
	//修改方法 预编译
	private static void updateUser(){
		JdbcTemplate jt=new JdbcTemplate(JDBCUtils1.getDataSource());
		int update=jt.update("delete from person where id=?,1");
		System.out.println(update);
	}
	//删除方法 预编译
	private static void deleteUser(){
		JdbcTemplate jt=new JdbcTemplate(JDBCUtils1.getDataSource());
		int update=jt.update("update person set id=?,name=?,age=?",1,"关羽",21);
		System.out.println(update);
	}
	//查询单个
	private static void findUserById1(){
		JdbcTemplate jt=new JdbcTemplate(JDBCUtils1.getDataSource());
		String sql = " select * from person where id=1";
		 //List<User> list =jt.query(sql.new BeanPropertyRowMapper<User> (User.class));
		//User user2=list.get(0);
		//System.out.println(user);
		//System.out.println(list);
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

	


	




