package com.niit.shoppingcart.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;
@Repository("userDetailsDAO")
@EnableTransactionManagement

public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean save(UserDetails userDetails) {
		
		try {
			sessionFactory.getCurrentSession().save(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(UserDetails userDetails) {
		try {
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(UserDetails userDetails) {
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public UserDetails get(String id) {
		String  hql = " from UserDetails where id ="+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> list = query.list();
		if(list == null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@Transactional
	public List<UserDetails> list() {
		String hql = "from UserDetails";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	@Transactional
	public boolean isValidUser(String id, String password) {
		
		String hql="from UserDetails where id='"+id+"' and password='"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails>  list=query.list();
		if(list!=null|| !list.isEmpty()){
	
			return true;
		}
			
				return false;
			
		}
		
		
	

}
