package com.niit.sportszone.dao;

import java.util.List;

import com.niit.sportszone.model.UserDetails;

public interface UserDetailsDAO {
	public boolean save(UserDetails userDetails);

	public boolean update(UserDetails userDetails);

	public boolean delete(UserDetails userDetails);

	public UserDetails get(String id);
	
	public UserDetails isValidUser(String id,String password);

	public List<UserDetails> list();
}
