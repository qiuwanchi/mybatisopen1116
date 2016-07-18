package com.secoo.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.secoo.entity.Orders;
import com.secoo.po.OrdersCustom;

public class OrdersCustomMapperTest {

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
	public void testFindOrdersUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		List<OrdersCustom> list = ordersCustomMapper.findOrdersUser();

System.out.println(list);
	}
	
	@Test
	public void testFindOrdersUser2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		List<Orders> list = ordersCustomMapper.findOrdersUserResultMap();

System.out.println(list);
	}
	
	@Test
	public void testFindOrdersUser3() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		List<Orders> list = ordersCustomMapper.findOrdersAndOrdersDetailResultMap();

System.out.println(list);
	}

}
