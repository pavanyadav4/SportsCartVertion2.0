package com.niit.shoppingcart;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sportszone.dao.CategoryDAO;
import com.niit.sportszone.model.Category;

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
	
	/*@Test
	public void categoryListTestCase()
	{
		List<Category> list = categoryDAO.list();
		int rowCount = list.size();
		assertEquals("Category List Test Case", rowCount,4);
	}
	
	@Test
	public void categoryAddTestCase()
	{
		category.setId("MOB_011");
		category.setName("Coolkk");
		category.setDescription("this Chgghgg");
		boolean flag = categoryDAO.save(category);
		assertEquals(flag, true);
	}*/
	
    @Test
	public void deleteTestCase(){
		category.setId("MOB_011");
		assertEquals(categoryDAO.delete(category),true);
	}
	
	/*@Test
	public void updateTestCase(){
		category.setId("MOB_003");
		category.setName("Iphone");
		category.setDescription("this is Iphone");
		assertEquals(categoryDAO.update(category),true);
	}

	@Test
	public void getCategoryTestCase(){
	category=categoryDAO.get("MOB_003");
	System.out.println(category.getDescription());
	System.out.println(category.getName());
	assertEquals(category.getName(), "asus");
	}*/
	
	
	
	
	
	

}
