package com.niit.shoppingcart.dao;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.ShippingAddress;

@Repository
public interface ShippingAddressDAO {

	public boolean saveOrUpdate(ShippingAddress shippingAddress);
	
	public boolean delete(ShippingAddress shippingAddress);
	
	public ShippingAddress get(String shipId);
}