package com.niit.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

public class TestCaseCart {
	
	@Autowired
	CartDAO cartDAO;	
	
	@Autowired
	Cart cart;
	
	AnnotationConfigApplicationContext context;		//instance of AnnotationConfigApplicationContext created...
	
	@Before
	public void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		cartDAO = (CartDAO) context.getBean("cartDAO");	
		cart = (Cart) context.getBean("cart");	
		
	}
	
	//@Test
	public void cartAddTestCase(){
		
		cart.setCartId("Cart001");
		cart.setUserId("sovanjana");
		cart.setCountProducts(2);
		cart.setGrandTotal(25000);
		
		assertEquals(cartDAO.saveOrUpdate(cart), true);		
	}
	
	//@Test
	public void cartDeleteTestCase(){

		cart.setCartId("Cart001");	
		
		assertEquals(cartDAO.delete(cart), true);		
	}
	
	//@Test
	public void getCartByUserId(){	
		
		assertEquals(cartDAO.getCartByUserId("sovanjana").getCartId(), "Cart001");
	}
	
	
	
}
