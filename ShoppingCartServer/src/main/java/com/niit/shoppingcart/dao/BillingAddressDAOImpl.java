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

import com.niit.shoppingcart.model.BillingAddress;

@EnableTransactionManagement
@Repository(value="billingAddressDAO")
public class BillingAddressDAOImpl implements BillingAddressDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BillingAddressDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public BillingAddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public BillingAddressDAOImpl(){
		
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
	public boolean saveOrUpdate(BillingAddress billingAddress) {
		try {
			log.debug("Starting of saveOrUpdate method...");
			System.out.println("i am here");
			sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
			log.debug("Ending of saveOrUpdate method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(BillingAddress billingAddress) {
		try {
			log.debug("Starting of delete method...");
			sessionFactory.getCurrentSession().delete(billingAddress);
			log.debug("Ending of delete method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}	
	}

	@Transactional
	public BillingAddress get(String billingAddressId) {		
		String hql="from billingaddress where id = " + "'" + "billingid" + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);		
		@SuppressWarnings("unchecked")
		List<BillingAddress> list = query.list();		
		if (list == null) {
			return null;
		} else {
			return list.get(0);
		}	
		
		//return sessionFactory.getCurrentSession().get(BillingAddress.class, billingAddressId);
	}

}