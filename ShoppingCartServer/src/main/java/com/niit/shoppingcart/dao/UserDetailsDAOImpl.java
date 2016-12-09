package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;

@EnableTransactionManagement
@Repository(value = "userDetailsDAO")		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public class UserDetailsDAOImpl implements UserDetailsDAO{	
	
	@Autowired		//@Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished..
	private SessionFactory sessionFactory;		//Create a session for making connection...  **ApplicationContextConfiguration.java
				
	public UserDetailsDAOImpl() {		//defaullt constructor of UserDetailsDAOImpl...
	}
	
	// getter/setter method for sessionFactory
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDetailsDAOImpl(SessionFactory sessionFactory){		//create UserDetailsDAOImpl construstor taking sessionfactory as parameter..
		this.sessionFactory = sessionFactory;
	}
	
	// Declare all CRUD Operations...
	
	@Transactional
	public boolean save(UserDetails userDetails){			//to save record if record does not exist..
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			userDetails.setRole("ROLE_USER");
			userDetails.setEnabled(true);
			sessionFactory.getCurrentSession().save(userDetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean update(UserDetails userDetails){			//to update the record that exist..
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean delete(UserDetails userDetails){			//to delete from userDetails..
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public UserDetails get(String id){
		
			//we need to declare the name i.e. hql (hibernate query language) to get response from the query related to db..
		String hql = " from UserDetails where id = " + "'"	+ id + "'";	//  select * from UserDetails where id = '___'
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetails> list = query.list();
		if(list==null ||list.size()==0 ){
			return null;
		}
		else{
			return list.get(0);
		}		
	}
	//---------------------------------------------------------------------------
		@Transactional
		public UserDetails getUserDetailsByName(String name) {
			String hql = " from UserDetails where name = " + "'" + name + "'";	//select * from UserDetails where name = '___'
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<UserDetails> list = query.list();
			if(list == null || list.size()==0){
				return null;
			}
			return list.get(0);
		}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserDetails> list() {
		
		String hql = " from UserDetails ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}	
	
	@Transactional
	public boolean saveOrUpdate(UserDetails userDetails) {
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			sessionFactory.getCurrentSession().saveOrUpdate(userDetails);		
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//----------------------------------------------------------------------------
	@Transactional
	public boolean isValidUser(String id, String password) {
		String hql="from UserDetails where id = :id and password = :password";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("password", password);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		if(list != null && !list.isEmpty()){
			return true;
		}		
		return false;
	}	
	
}
