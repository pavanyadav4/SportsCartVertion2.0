package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;

	@Id
	private String cartId;
	
	private String userId;
	
	private double grandTotal;
	
	private int countProducts;
	
	public Cart() {
		this.cartId ="CART"+ UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
	/* getters/setters for all the fields taken... */
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCountProducts() {
		return countProducts;
	}
	public void setCountProducts(int countProducts) {
		this.countProducts = countProducts;
	}

}