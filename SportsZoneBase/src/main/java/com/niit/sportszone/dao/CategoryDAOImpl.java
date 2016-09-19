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

@Repository("categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDAO.class);
	
			
			
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public boolean save(Category category) {
		
		try {
			log.debug("starting of the save method");
			sessionFactory.getCurrentSession().save(category);
			log.debug("end of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("exception occurred in save method"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Category category) {
		try {
			log.debug("starting of the save method");
			sessionFactory.getCurrentSession().update(category);
			log.debug("end of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("exception occurred in save method"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(Category category) {
		try {
			log.debug("starting of the save method");
			sessionFactory.getCurrentSession().delete(category);
			log.debug("end of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("exception occurred in save method"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public Category get(String id) {
		log.debug("starting of the method get");
		//select * from Product where id='101'// we giving qotations because  we have taken varchar
	log.info("trying to get product based on id:"+id);
	String hql=" from Product where id =" + " ' " + id + " ' ";
	log.info("the hsql query is :"+ hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		if(list == null || list.isEmpty())
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
	public List<Category> list() {
		log.debug("starting of the list method");
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("end of the method list");
		List<Category> list =query.list();
		if(list==null || list.isEmpty()){
			log.info("no products are avaliable");
		}
		return list;
	}
	}