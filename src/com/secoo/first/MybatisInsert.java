package com.secoo.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.secoo.entity.User;

public class MybatisInsert {

	public static void main(String[] args) throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session =  sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUserName("邱万迟1");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("赣州");
		session.insert("test.insertUser", user);
		session.insert("test.insertUser", user);
		
		//session.commit();//提交事务
		
		session.close();
	}
}
