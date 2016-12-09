package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class UserDetailsTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//Here i'm going to perform basic database operations using hibernate provided functions....
		
		UserDetailsDAO userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		UserDetails userDetails = (UserDetails) context.getBean("userDetails");
		
		/*userDetails.setId("USER004");
		userDetails.setName("USER_name_002");
		userDetails.setPassword("pwd002");
		userDetails.setEmail("user2@niit.com");
		userDetails.setPhone("0987654321");
		userDetails.setAddress("Delhi");*/
				
				
		if(userDetailsDAO.save(userDetails) == true){
			System.out.println("UserDetails created successfully...");
		}
		else{
			System.out.println("Not able to create userDetails...");
		}
	}

}
