package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Supplier;

@Repository		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public interface SupplierDAO {		//DAO - Data Access Object...

	// Declare all CRUD Operations...

	public boolean save(Supplier supplier);		// to save the record that does not exist..

	public boolean update(Supplier supplier); 	// to update the record that exist..
	
	public boolean saveOrUpdate(Supplier supplier);

	public boolean delete(Supplier supplier); 	// to delete the record from supplier..

	public Supplier get(String id);

	public List<Supplier> list();
}
