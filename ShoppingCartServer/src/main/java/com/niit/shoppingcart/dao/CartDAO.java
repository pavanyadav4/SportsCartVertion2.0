package com.niit.shoppingcart.dao;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Cart;

@Repository
public interface CartDAO {

	public boolean saveOrUpdate(Cart cart);
	
	public boolean delete(Cart cart);
	
	public Cart getCartByUserId(String userId);

	//public List<Cart> list();
	
	//public List<OrderedItems> listOrderedItems(String userId);
	
}