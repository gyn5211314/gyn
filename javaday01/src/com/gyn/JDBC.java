package com.gyn;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import java.io.InputStream;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBC {
	public static void main(String[] args) throws Exception {
		Properties pro=new Properties();
		InputStream resourceAsStream=JDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");
		pro.load(resourceAsStream);
		String property=pro.getProperty("name");
		String password=pro.getProperty("password");
		System.out.println(property);
		DataSource datascource=DruidDataSourceFactory.createDataSource(pro);
		System.out.println(datascource.getConnection());
		Connection connection=datascource.getConnection();
		Statement createStatement=connection.createStatement();
		String sql=" select * from student";
		ResultSet rs= createStatement.executeQuery(sql);
		while(rs.next()){
			String name=rs.getString("SName");
			String address=rs.getString("SNo");
			Integer age=rs.getInt("Sage");
			System.out.println(name+address+age);
		}
		connection.close();
	}
		
		
}
