package com.niit.shoppingcart;

import static org.junit.Assert.*;





import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sportszone.dao.SupplierDAO;
import com.niit.sportszone.model.Supplier;

public class TestCaseSupplier {

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplier = (Supplier)context.getBean("supplier");
	}
	
	/*@Test
	public void supplierListTestCase()
	{
		List<Supplier> list = supplierDAO.list();
		int rowCount = list.size();
		assertEquals("Supplier List Test Case", rowCount,2);
	}*/
	
	@Test
	public void supplierAddTestCase()
	{
		supplier.setId("MO01");
		supplier.setName("Cool");
		supplier.setAddress("Hyd");
		//boolean flag = supplierDAO.save(supplier);
		assertEquals(supplierDAO.save(supplier), true);
	}
	
    /*@Test
	public void deleteTestCase(){
		supplier.setId("MOB_009");
		assertEquals(supplierDAO.delete(supplier),true);
	}
	
	/*@Test
	public void updateTestCase(){
		supplier.setId("MOB_003");
		supplier.setName("asus");
		supplier.setDescription("this is asus");
		assertEquals(supplierDAO.update(supplier),true);
	}*/

	/*@Test
	public void getSupplierTestCase(){
	supplier=supplierDAO.get("MOB_003");
	System.out.println(supplier.getDescription());
	System.out.println(supplier.getName());
	assertEquals(supplier.getName(), "asus");
	}*/
	
	
	
	
	
	

}
