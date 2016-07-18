package com.secoo.mybatis.mapper;

import java.util.List;

import com.secoo.entity.Orders;
import com.secoo.po.OrdersCustom;

public interface OrdersCustomMapper {

	public List<OrdersCustom> findOrdersUser();
	
	public List<Orders> findOrdersUserResultMap();
	
	public List<Orders> findOrdersAndOrdersDetailResultMap();
	
}
