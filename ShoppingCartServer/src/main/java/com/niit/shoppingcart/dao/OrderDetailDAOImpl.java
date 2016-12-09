package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.OrderDetail;

@Repository(value = "orderDetailDAO")
public class OrderDetailDAOImpl implements OrderDetailDAO {

	private static final Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	public OrderDetailDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public OrderDetailDAOImpl() {
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
	public boolean saveOrUpdate(OrderDetail orderDetail) {
		try {
			log.debug("Starting of saveOrUpdate method...");
			sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);
			log.debug("Ending of saveOrUpdate method...");
			return true;
		} catch (Exception e) {
			log.error("Error occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String orderDetailId) {
		try {
			log.debug("Starting of delete method...");
			OrderDetail orderDetailTodelete = new OrderDetail();
			orderDetailTodelete.setOrderDetailId(orderDetailId);
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
	public List<OrderDetail> list() {
		log.debug("Starting of list method...");
		String hql="from OrderDetail";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of list method...");
		return query.list();
	}

}
