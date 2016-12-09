package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;

@EnableTransactionManagement
@Repository(value = "supplierDAO")		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired		//@Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished..
	private SessionFactory sessionFactory;		//create session to make a connection..
	
	public SupplierDAOImpl() {		//defaullt constructor of SupplierDAOImpl...
		
	}
		// getter/setter method for sessionFactory
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SupplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	// Declare all CRUD Operations...
	
	@Transactional
	public boolean save(Supplier supplier){		//to save the record that does not exist..
				//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
			
	@Transactional
	public boolean update(Supplier supplier){	//to update the record that exist..
				
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
			
	@Transactional
	public boolean delete(Supplier supplier){	//to delete the record from supplier..
				
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public Supplier get(String id){
				
	//we need to specify the query lang i.e. hql (hibernate query language) to get response from the query related to db..
		String hql = " from Supplier where id = " + "'" + id + "'";  //  select * from Supplier where id = '___'
				
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
				
		@SuppressWarnings("unchecked")
		List<Supplier> list = query.list();
		
		if(list==null){
			return null;
		}
		else{
			return list.get(0);
		}
	}
			
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Supplier> list(){
				
		String hql = " from Supplier ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
			
	@Transactional
	public boolean saveOrUpdate(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
}
