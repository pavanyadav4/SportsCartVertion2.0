package com.niit.shoppingcart.dao;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.CardDetail;

@Repository
public interface CardDetailDAO {

	public boolean saveOrUpdate(CardDetail cardDetail);
	
}