package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;

	@Id
	private String cartItemId;
	
	private String cartId;
	
	private String userId;
	
	private String productId;	

	private int countProducts;
	
	private double grandTotal;
	
	public CartItem() {
		this.cartItemId ="CARTITEM" +UUID.randomUUID().toString().substring(24).toUpperCase();
	}

	/* getters/setters for all the fields taken... */
	
	public String getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

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

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getCountProducts() {
		return countProducts;
	}
	public void setCountProducts(int countProducts) {
		this.countProducts = countProducts;
	}

	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

}