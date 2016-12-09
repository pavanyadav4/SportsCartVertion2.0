package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//Here i'm going to perform basic database operations using hibernate provided functions....
		
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier = (Supplier) context.getBean("supplier");
		
		supplier.setId("SUP002");
		supplier.setName("Reliance Trendz");
		supplier.setAddress("Mumbai");
		
		if(supplierDAO.save(supplier) == true){
			System.out.println("Supplier created successfully...");
		}
		else{
			System.out.println("Not able to create supplier...");
		}

	}

}
