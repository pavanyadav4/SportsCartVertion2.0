package com.niit.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.model.Order;

public class TestCaseOrder {

	@Autowired
	Order order;	
	@Autowired
	OrderDAO orderDAO;
	
	AnnotationConfigApplicationContext context;		//instance of AnnotationConfigApplicationContext created...
	
	@Before
	public void init(){		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		orderDAO = (OrderDAO) context.getBean("orderDAO");	
		order = (Order) context.getBean("order");			
	}
	
	//@Test
	public void addOrder(){
		//order.setOrderId("odr_debjit");
		order.setUserId("debjit002");
		order.setGrandTotal(909);
		order.setBillingAddressId("BILL9DC8A680E940");
		
		
		
		assertEquals(orderDAO.saveOrUpdate(order), true);
	}
	
}
