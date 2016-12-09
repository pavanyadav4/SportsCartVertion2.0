package com.niit.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.BillingAddressDAO;
import com.niit.shoppingcart.model.BillingAddress;

public class TestCaseBillingAddress {

	@Autowired
	BillingAddress billingAddress;	
	@Autowired
	BillingAddressDAO billingAddressDAO;
	
	AnnotationConfigApplicationContext context;		//instance of AnnotationConfigApplicationContext created...
	
	@Before
	public void init(){		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		billingAddressDAO = (BillingAddressDAO) context.getBean("billingAddressDAO");	
		billingAddress = (BillingAddress) context.getBean("billingAddress");			
	}
	
	//@Test
	public void addBillingAddress(){
		billingAddress.setUserId("debjit002");
		billingAddress.setLine1("C/5/1 Block-C Baghajatin");
		billingAddress.setLine2("Kolkata-700092");
		billingAddress.setCity("Kolkata");
		billingAddress.setState("West Bengal");
		billingAddress.setZipCode("700092");
		billingAddress.setCountry("India");	

		assertEquals(billingAddressDAO.saveOrUpdate(billingAddress), true);
	}
	
}
