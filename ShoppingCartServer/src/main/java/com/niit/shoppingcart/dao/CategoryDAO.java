
package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;

@Repository		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public interface CategoryDAO {		//DAO - Data Access Object...
	
	// Declare all CRUD Operations...
	
	public boolean save(Category category);		//to save the record that does not exist..
	
	public boolean update(Category category);	//to update the record that exist..
	
	public boolean saveOrUpdate(Category category);
	
	public boolean delete(Category category);	//to delete the record from category..
	
	public Category get(String id);
	
	public List<Category> list();
	
}
