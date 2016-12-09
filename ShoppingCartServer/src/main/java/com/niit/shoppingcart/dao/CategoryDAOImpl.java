package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;


@EnableTransactionManagement
@Repository(value = "categoryDAO")		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public class CategoryDAOImpl implements CategoryDAO{	
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	@Autowired		//@Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished..
					//first we need to create a connection. 
	private SessionFactory sessionFactory;		//Create a session for making connection...  **ApplicationContextConfiguration.java
	
	public CategoryDAOImpl() {		//defaullt constructor of CategoryDAOImpl...
		
	}
	public CategoryDAOImpl(SessionFactory sessionFactory){		//create CategoryDAOImpl construstor taking sessionfactory as parameter..
		this.sessionFactory = sessionFactory;
	}
	
		/*  getter/setter method for sessionFactory  */
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	// Declare all CRUD Operations...
	
	@Transactional
	public boolean save(Category category){		//to save record if record does not exist..
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			log.debug("Starting of save method...");
			sessionFactory.getCurrentSession().save(category);
			log.debug("End of save method...");
			return true;
		} catch (Exception e) {			
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean update(Category category){	//to update the record that exist..
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			log.debug("Starting of update method...");
			sessionFactory.getCurrentSession().update(category);
			log.debug("End of update method...");
			return true;
		} catch (Exception e) {
			
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Transactional
	public boolean delete(Category category){	//to delete from category..
		try {
			log.debug("Starting of delete method...");
			sessionFactory.getCurrentSession().delete(category);
			log.debug("End of delete method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Transactional
	public Category get(String id){
		
		log.debug("Starting of get method...");
			//we need to declare the name i.e. hql (hibernate query language) to get response from the query related to db..
		String hql = " from Category where id = " + "'"	+ id + "'";	
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();
		
		if(list==null){
			return null;
		}
		else{
			return list.get(0);
		}		
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Category> list() {
		
		log.debug("Starting of list method...");
		String hql = " from Category ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		log.debug("list method ends...");
		return query.list();

	}

	
	@Transactional
	public boolean saveOrUpdate(Category category) {
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			log.debug("Starting of saveOrUpdate method...");
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			log.debug("End of saveOrUpdate method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
}
