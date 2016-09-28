package com.niit.shoppingcart;

import static org.junit.Assert.*;





import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class TestCaseCategory {

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		category = (Category)context.getBean("category");
	}
	
	@Test
	public void categoryAddTestCase()
	{
		category.setCategoryid("8");
		category.setName("ah55hj");
		category.setDescription("thigs");
		boolean flag = categoryDAO.save(category);
		assertEquals(flag, true);
	}
	
	
	
	/*@Test
	public void categoryListTestCase()
	{
		List<Category> list = categoryDAO.list();
		int rowCount = list.size();
		assertEquals("Category List Test Case", rowCount,1);
	}*/
	/*
	@Test
	public void deleteTestCase(){
		category.setId("MOB_004");
		assertEquals(categoryDAO.delete(category),true);
	}*/
	/*
	@Test
	public void updateTestCase(){
		category.setId("MOB_003");
		category.setName("asus");
		category.setDescription("this is asus phone");
		assertEquals(categoryDAO.update(category),true);
	}*/

	/*@Test
	public void getCategoryTestCase(){
	category=categoryDAO.get("");
	System.out.println(category.getDescription());
	assertEquals(category.getName(), "mobile");
	}
	
	*/
	
	
	
	

}
