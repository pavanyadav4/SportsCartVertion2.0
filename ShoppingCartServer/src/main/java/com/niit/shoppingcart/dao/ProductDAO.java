package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Product;

@Repository		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public interface ProductDAO {		//DAO - Data Access Object...
	
	// Declare all CRUD Operations...
	
	public boolean save(Product product);		//to save the record that does not exist..
	
	public boolean update(Product product);		//to update the record that exist..
	
	public boolean saveOrUpdate(Product product);
	
	public boolean delete(Product product);		//to delete the record from Product..
	
	public Product get(String id);
	
	public List<Product> list();
}
