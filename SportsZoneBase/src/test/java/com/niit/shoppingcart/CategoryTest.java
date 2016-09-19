package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sportszone.dao.CategoryDAO;
import com.niit.sportszone.model.Category;


public class CategoryTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category)context.getBean("category");
		category.setId("CG234");
		category.setName("CGNam34");
		category.setDescription("This isdescdd");
		
		if(categoryDAO.save(category)==true)
		{
			System.out.println("Category created successfully");
		}
		else{
			System.out.println("Not able to create the category");
		}
	}

}
