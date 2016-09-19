package com.niit.sportszone.dao;

import java.util.List;

import com.niit.sportszone.model.Cart;

public interface CartDAO {
	public boolean save(Cart cart);

	public boolean update(Cart cart);

	public boolean delete(Cart cart);

	public Cart get(String id);

	public List<Cart> list();
}
