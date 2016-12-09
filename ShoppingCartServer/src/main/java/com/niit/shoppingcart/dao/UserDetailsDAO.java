package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.UserDetails;

@Repository		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public interface UserDetailsDAO {		//DAO - Data Access Object...
	
	// Declare all CRUD Operations...
	
	public boolean save(UserDetails userDetails);		//to save the record that does not exist..
	
	public boolean update(UserDetails userDetails);		//to update the record that exist..
	
	public boolean saveOrUpdate(UserDetails userDetails);	//to save/update the record that does not exist..
	
	public boolean delete(UserDetails userDetails);		//to delete the record from userDetails..
	
	public UserDetails get(String id);
	
	public List<UserDetails> list();
	
	public boolean isValidUser(String id, String password);
	
	public UserDetails getUserDetailsByName(String name);
	
	
}
