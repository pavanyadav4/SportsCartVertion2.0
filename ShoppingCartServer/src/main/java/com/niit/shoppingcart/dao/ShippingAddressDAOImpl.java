package com.niit.shoppingcart.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.ShippingAddress;

@EnableTransactionManagement
@Repository(value = "shippingAddressDAO")
public class ShippingAddressDAOImpl implements ShippingAddressDAO {

	private static final Logger log = LoggerFactory.getLogger(ShippingAddressDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public ShippingAddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ShippingAddressDAOImpl() {
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
	public boolean saveOrUpdate(ShippingAddress shippingAddress) {
		try {
			log.debug("Starting of saveOrUpdate method...");
			sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
			log.debug("Ending of saveOrUpdate method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(ShippingAddress shippingAddress) {
		try {
			log.debug("Starting of delete method...");
			sessionFactory.getCurrentSession().delete(shippingAddress);
			log.debug("Ending of delete method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public ShippingAddress get(String shipId) {
		log.debug("Starting of get method...");
		ShippingAddress shippingAddress = (ShippingAddress) sessionFactory.getCurrentSession().get(ShippingAddress.class, shipId);
		log.debug("Ending of get method...");
		return shippingAddress;
	}
}