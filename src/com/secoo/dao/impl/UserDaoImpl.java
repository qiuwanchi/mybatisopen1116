package com.secoo.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.secoo.dao.UserDao;
import com.secoo.entity.User;

public class UserDaoImpl implements UserDao{

	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User findUserByUserName(String userName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserByUserName", "邱万迟");
		sqlSession.close();//释放资源
		return user;
	}

}
