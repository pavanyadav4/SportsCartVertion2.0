package com.niit.sportszone.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sportszone.model.Category;
import com.niit.sportszone.model.Product;

@Repository("productDAO")
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO {
	

		private static final Logger log=LoggerFactory.getLogger("ProductDAO.class");
	
	
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public boolean save(Product product) {
		
		try {
			log.debug("starting of the save method");
			sessionFactory.getCurrentSession().save(product);
			log.debug("end of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("exception occured in save:"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Product product) {
		try {
			log.debug("starting of the update method");
			sessionFactory.getCurrentSession().update(product);
			log.debug("end of the update method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("exception");
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(Product product) {
		try {
			log.debug("starting of the delete method");
			sessionFactory.getCurrentSession().delete(product);
			log.debug("end of the delete method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public Product get(String id) {
		log.debug("starting of the get method");
		log.info("trying to get product based on id:"+id);
		String hql=" from Product where id =" + " ' " + id + " ' ";
		log.info("the hsql query is :"+ hql);
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();
		if(list == null||list.isEmpty())
		{
			log.info("no products are avaliable with this id:"+id);
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@Transactional
	public List<Product> list() {
		log.debug("starting of the List method");
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("end of the list method");
		List<Product> list =query.list();
		if(list==null || list.isEmpty()){
			log.info("no products are avaliable");
		}
		return list;
	}
	}