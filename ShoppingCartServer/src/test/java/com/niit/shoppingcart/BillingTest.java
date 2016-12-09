package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.BillingAddressDAO;
import com.niit.shoppingcart.model.BillingAddress;

public class BillingTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		System.out.println("i am here 1");
		BillingAddressDAO billingAddressDAO = (BillingAddressDAO) context.getBean("billingAddressDAO");
		System.out.println("i am here 2");
		BillingAddress billingAddress = (BillingAddress) context.getBean("billingAddress");
		System.out.println("i am here 3");
		
		//billingAddress.setBillingAddressId("debjitmahishadal");		
		billingAddress.setUserId("debjit002");
		billingAddress.setLine1("Mhishadal");
		billingAddress.setLine2("Haldia");
		billingAddress.setCity("Haldia");
		billingAddress.setState("West Bengal");
		billingAddress.setZipCode("721628");
		billingAddress.setCountry("India");
		
		if(billingAddressDAO.saveOrUpdate(billingAddress) == true) {
			System.out.println("BillingAddress created successfully...");
		}
		else{
			System.out.println("Not Able to create BillingAddress...");
		}
		
	}
}
