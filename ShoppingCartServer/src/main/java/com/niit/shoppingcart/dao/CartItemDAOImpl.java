package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.CartItem;

@EnableTransactionManagement
@Repository("cartItemDAO")
public class CartItemDAOImpl implements CartItemDAO {

	private static final Logger log = LoggerFactory.getLogger(CartItemDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public CartItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public CartItemDAOImpl() {
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
	public boolean saveOrUpdate(CartItem cartItem) {
		try {
			log.debug("Starting of saveOrUpdate method...");
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			log.debug("Ending of saveOrUpdate method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean delete(CartItem cartItem) {
		try {
			log.debug("Starting of delete method...");
			Session session = sessionFactory.openSession();
			session.delete(cartItem);
			session.flush();
			session.close();
			//sessionFactory.getCurrentSession().delete(cartItem);
			log.debug("Ending of delete method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public CartItem get(String cartItemId) {
		log.debug("Starting of get method...");
		String hql = "from CartItem where cartItemId=" + "'" + cartItemId + "'";
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		
		
		
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<CartItem> list = query.list();
		
		session.flush();
		session.close();
		log.debug("Ending of get method...");
		if(list==null){
			return null;
		}
		else{
			return list.get(0);
		}
	}	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CartItem> getCartItemByUserId(String userId) {
		log.debug("Starting of getCartItemByUserId method...");
		String hql = "from CartItem where userId=" + "'" + userId + "'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of getCartItemByUserId method...");
		return query.list();
	}

/*	@SuppressWarnings("unchecked")
	@Transactional
	public List<CartItem> list() {
		log.debug("Starting of list method...");
		String hql = " from CartItem ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of list method...");
		return query.list();
	}*/
}


