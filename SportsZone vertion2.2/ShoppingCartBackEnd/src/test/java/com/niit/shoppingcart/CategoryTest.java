package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;


public class CategoryTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category)context.getBean("category");
		category.setCategoryid("CG231");
		category.setName("CGNa32");
		category.setDescription("This isdesc");
		
		if(categoryDAO.save(category)==true)
		{
			System.out.println("Category created successfully");
		}
		else{
			System.out.println("Not able to create the category");
		}
	}

}
