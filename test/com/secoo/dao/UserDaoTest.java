package com.secoo.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.secoo.dao.impl.UserDaoImpl;
import com.secoo.entity.User;

public class UserDaoTest {

	SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testFindUserByUserName() {
		UserDao dao = new UserDaoImpl(sqlSessionFactory);
		User user = dao.findUserByUserName("qiuwanchi");
		
		System.out.println(user);
	}

}
