package com.gyn.dao;

import java.util.List;

import com.gyn.bean.User;

public interface UserDao {
	List<User> findAllUser();

}
