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

import com.niit.shoppingcart.model.Cart;

@EnableTransactionManagement
@Repository(value = "cartDAO")
public class CartDAOImpl implements CartDAO {

	private static final Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public CartDAOImpl() {		
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
	public boolean saveOrUpdate(Cart cart) {
		try {
			log.debug("Starting of saveOrUpdate method...");
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			log.debug("Ending of saveOrUpdate method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Cart cart) {
		try {
			log.debug("Starting of delete method...");
			sessionFactory.getCurrentSession().delete(cart);
			log.debug("Ending of delete method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Cart getCartByUserId(String userId) {
		log.debug("Starting of getCartByUserId method...");
		String hql = "from Cart where userId=" + "'" + userId + "'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = query.list();
		//System.out.println("I reached at getCartByUserId method...");
		if(list == null || list.isEmpty()){
			return null;
		}
		else{
			return list.get(0);
		}
	}
	
/*	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cart> list() {
		log.debug("Starting of list method...");
		String hql = " from Cart ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of list method...");
		return query.list();
	}*/
}