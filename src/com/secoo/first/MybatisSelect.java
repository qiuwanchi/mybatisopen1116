package com.secoo.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.secoo.entity.User;

public class MybatisSelect {

	public static void main(String[] args) throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session =  sqlSessionFactory.openSession();
		
		User user = session.selectOne("test.findUserByUserName", "邱万迟");
		session.close();//释放资源
		System.out.println(user);
	}
}
