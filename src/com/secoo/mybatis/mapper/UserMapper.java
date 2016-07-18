package com.secoo.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.secoo.entity.User;

public interface UserMapper {

	public List<User> findUserByUserName(String userName);
	
	public List<Map> findUserByUserName2(String userName);
}
