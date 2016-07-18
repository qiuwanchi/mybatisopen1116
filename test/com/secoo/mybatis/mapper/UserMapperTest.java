package com.secoo.mybatis.mapper;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.secoo.entity.User;

public class UserMapperTest {

private SqlSessionFactory sqlSessionFactory;
	
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByUserName("%小明%");
		
		System.out.println(list);
	}

	@Test
	public void testFindUserByUserName2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Map> list = userMapper.findUserByUserName2("%小明%");
		
		System.out.println(list);
	}

}
