package com.secoo.dao;

import com.secoo.entity.User;

public interface UserDao {

	public User findUserByUserName(String userName);
	
}
