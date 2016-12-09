package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.OrderDetail;

@Repository
public interface OrderDetailDAO {

	// Declare all CRUD Operations... 
	
	public boolean saveOrUpdate(OrderDetail orderDetail);

	public boolean delete(String orderDetailId);

	public List<OrderDetail> list();

}