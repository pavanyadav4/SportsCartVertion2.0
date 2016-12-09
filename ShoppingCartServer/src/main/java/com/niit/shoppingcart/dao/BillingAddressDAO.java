package com.niit.shoppingcart.dao;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.BillingAddress;

@Repository
public interface BillingAddressDAO {
	
	public boolean saveOrUpdate(BillingAddress billingAddress);

	public boolean delete(BillingAddress billingAddress);

	public BillingAddress get(String billingAddressId);
}