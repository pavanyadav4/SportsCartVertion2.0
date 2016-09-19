package com.niit.shoppingcart;

import static org.junit.Assert.*;



import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sportszone.dao.UserDetailsDAO;
import com.niit.sportszone.model.UserDetails;

public class TestCaseUserDetails {

	@Autowired
	UserDetailsDAO userDetailsDAO;
	@Autowired
	UserDetails userDetails;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDetailsDAO = (UserDetailsDAO)context.getBean("userDetailsDAO");
		userDetails = (UserDetails)context.getBean("userDetails");
	}
	
	
	
	/*@Test
	public void userDetailsAddTestCase()
	{
		userDetails.setId("PRO_004");
		userDetails.setName("COOLPAD");
		userDetails.setAddress("hyd");
		userDetails.setContact("99484");
		userDetails.setEmail("srava@gmail.com");
		userDetails.setPassword("sravan");
		
		assertEquals(userDetailsDAO.save(userDetails),true);
	}
	
	
	/*@Test
	public void userDetailsListTestCase()
	{
		List<UserDetails> list = userDetailsDAO.list();
		int rowCount = list.size();
		assertEquals("UserDetails List Test Case", rowCount,2);
	}
	
	@Test
	public void deleteTestCase(){
		userDetails.setId("PRO_004");
		assertEquals(userDetailsDAO.delete(userDetails),true);
	}
	
	/*@Test
	public void updateTestCase(){
		userDetails.setId("PRO_002");
		userDetails.setName("asus");
		userDetails.setDescription("this is asus");
		userDetails.setPrice("15000");
		assertEquals(userDetailsDAO.update(userDetails),true);
	}*/

	@Test
	public void getUserDetailsTestCase(){
		userDetails=userDetailsDAO.get("PRO_002");
		System.out.println(userDetails.getName());
		assertEquals(userDetails.getName(),"COOLPAD");
	}
	
 }
