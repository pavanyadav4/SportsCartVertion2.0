package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Order;

public interface OrderDAO {

	public boolean saveOrUpdate(Order order);

	public boolean delete(Order order);

	public List<Order> list();

}