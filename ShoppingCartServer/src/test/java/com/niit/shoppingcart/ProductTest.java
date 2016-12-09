package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//Here i'm going to perform basic database operations using hibernate provided functions....
		
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product product = (Product) context.getBean("product");
		
	/*	product.setId("PRO002");
		product.setName("PRO_name_001");
		product.setDescription("This is product001 description...");
		product.setPrice(5000);*/
				
		if(productDAO.save(product) == true){
			System.out.println("Product created successfully...");
		}
		else{
			System.out.println("Not able to create product...");
		}
	}

}
