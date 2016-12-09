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

import com.niit.shoppingcart.model.Order;

@EnableTransactionManagement
@Repository(value="orderDAO")
public class OrderDAOImpl implements OrderDAO {

	private static final Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public OrderDAOImpl() {
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
	public boolean saveOrUpdate(Order order) {
		try {
			log.debug("Starting of saveOrUpdate method...");
			sessionFactory.getCurrentSession().saveOrUpdate(order);
			log.debug("Ending of saveOrUpdate method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(Order order) {
		try {
			log.debug("Starting of delete method...");
			sessionFactory.getCurrentSession().delete(order);
			log.debug("Ending of delete method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Order> list() {
		String hql="from Order";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
