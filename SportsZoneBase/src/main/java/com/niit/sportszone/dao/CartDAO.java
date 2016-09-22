package com.niit.sportszone.dao;

import java.util.List;


import com.niit.sportszone.model.Cart;


public interface CartDAO {

	void saveOrUpdate(Cart cart);
	
	void delete(String cartId);
	
	Cart getCartByCustomerId(String customerId);
	
	List<Cart> listCart();
	

	
	/*Cart createCart(Cart cart);

	Cart read(String cartId);

	void update(String cartId, Cart cart);

	void delete(String Id);
*/
}
