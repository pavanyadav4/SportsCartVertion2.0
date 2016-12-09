package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;


public class TestCaseSupplier {

	@Autowired
	SupplierDAO supplierDAO;	//instance of SupplierDAO created...
	
	@Autowired
	Supplier supplier;		//instance of Supplier created...
	
	AnnotationConfigApplicationContext context;
	
	//Initialize test case...
	@Before
	public void init(){		//init is just a method to initialize the instances...
		
		context = new AnnotationConfigApplicationContext();		//object of AnnotationConfigApplicationContext created...
		context.scan("com.niit");		//scan base package of the application...
		context.refresh();		//referesh the application...
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");		
		
	}
	
	//@Test
	public void supplierListTestCase(){
		
		//List<Supplier> list = supplierDAO.list();
		//int rowCount = list.size();
		//assertEquals(4, rowCount);		//instead of using these three lines we can use just a single line as follows...
		
		assertEquals(supplierDAO.list().size(), 2);
		
	}
	
	//@Test
	public void supplierAddTestCase(){
		supplier.setId("SUP002");
		supplier.setName("Big Bazar");
		supplier.setAddress("Delhi");
		
		//boolean flag = supplierDAO.save(supplier);
		//assertEquals(flag, true);		//instead of using these three lines we can use just a single line as follows...
		
		assertEquals(supplierDAO.save(supplier), true);
		
	}

	//@Test
	public void supplierGetTestCase(){
		//supplier = supplierDAO.get("SUP001");
		//assertEquals("Reliance Trendz", supplier.getName());		//instead of using these three lines we can use just a single line as follows...
		
		assertEquals(supplierDAO.get("SUP001").getName(), "Pantaloons");
	}
	
}
