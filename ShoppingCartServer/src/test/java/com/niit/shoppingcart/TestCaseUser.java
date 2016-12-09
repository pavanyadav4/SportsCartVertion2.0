package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;


public class TestCaseUser {

	/*@Autowired
	UserDetailsDAO userDetailsDAO;			//instance of UserDetailsDAO created...
	
	@Autowired
	UserDetails userDetails;				//instance of UserDetails created...
	
	AnnotationConfigApplicationContext context;		//instance created successfully...
	
	//Initialize test case...
	@Before
	public void init(){		//init is just a method to initialize the instances...
		
		context = new AnnotationConfigApplicationContext();		//object of AnnotationConfigApplicationContext created...
		context.scan("com.niit");		//scan base package of the application...
		context.refresh();		//referesh the application...
		
		userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		userDetails = (UserDetails) context.getBean("userDetails");		
		
	}
	
	//@Test
	public void userListTestCase(){
		
		//List<UserDetails> list = userDetailsDAO.list();
		//int rowCount = list.size();		
		//assertEquals(3, rowCount);		//instead of using these three lines we can use just a single line as follows...
		
		assertEquals(userDetailsDAO.list().size(), 2);
		
	}
	
	//@Test
	public void userAddTestCase(){		
		userDetails.setId("USER002");
		userDetails.setName("USER_name_002");
		userDetails.setPassword("pwd002");
		userDetails.setEmail("user002@niit.com");
		userDetails.setPhone("1234014321");
		userDetails.setAddress("Hydrabad");
		userDetails.setAdmin(false);
		
		
		//boolean flag = userDetailsDAO.save(userDetails);
		//assertEquals(flag, true);		//instead of using these three lines we can use just a single line as follows...
		
		assertEquals(userDetailsDAO.save(userDetails), true);
		
	}
	
	//@Test
	public void userUpdateTestCase(){
		
		userDetails.setId("USER005");
		userDetails.setName("USER_name_005 modified");
		userDetails.setPassword("pwd005");
		userDetails.setEmail("user005@niit.com");
		userDetails.setPhone("1234004321");
		userDetails.setAddress("Hydrabad");
		
		assertEquals(userDetailsDAO.update(userDetails), true);
	}

	//@Test
	public void userGetTestCase(){
		//userDetails = userDetailsDAO.get("USER001");
		//assertEquals("USER_name_001", userDetails.getName());		//instead of using these three lines we can use just a single line as follows...
		
	//	assertEquals(userDetailsDAO.get("USER001").getName(), "USER_name_001");
		
		System.out.println("Perfect Match...");
	}*/
	
}
