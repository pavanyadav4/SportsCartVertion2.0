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
	private static final long serialVersionUID = 1L;
	@Id
	private String cartId;
	
	private String customerId;
	private double grandTotal;
	private int noOfProducts;

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public Cart() {
		this.cartId ="CART"+ UUID.randomUUID().toString().substring(24).toUpperCase();
	}

	/*
	 * private String cartId; private Map<String, CartItem> cartItems; private
	 * double grandTotal;
	 * 
	 * public String getCartId() { return cartId; }
	 * 
	 * public void setCartId(String cartId) { this.cartId = cartId; }
	 * 
	 * public Map<String, CartItem> getCartItems() { return cartItems; }
	 * 
	 * public void setCartItems(Map<String, CartItem> cartItems) {
	 * this.cartItems = cartItems; }
	 * 
	 * public double getGrandTotal() { return grandTotal; }
	 * 
	 * public void setGrandTotal(double grandTotal) { this.grandTotal =
	 * grandTotal; }
	 * 
	 * private Cart() { cartItems = new HashMap<String, CartItem>(); grandTotal
	 * = 0;
	 * 
	 * }
	 * 
	 * public Cart(String cartId){ this(); this.cartId= cartId; }
	 * 
	 * 
	 * 
	 * 
	 * // Cart Methods
	 * 
	 * public void addCartItems(CartItem cartItem) { String
	 * productId=cartItem.getProduct().getProductId();
	 * 
	 * if(cartItems.containsKey(productId)) { CartItem
	 * existingCartItem=cartItems.get(productId);
	 * existingCartItem.setQuantity(existingCartItem.getQuantity()+cartItem.
	 * getQuantity()); cartItems.put(productId, existingCartItem); }
	 * 
	 * updateGrandTotal(); }
	 * 
	 * public void removeCartItem(CartItem cartItem) { String productId=
	 * cartItem.getProduct().getProductId(); cartItems.remove(productId);
	 * updateGrandTotal(); }
	 * 
	 * public void updateGrandTotal(){ grandTotal=0; for(CartItem cartItem :
	 * cartItems.values()) { grandTotal=grandTotal+cartItem.getTotalPrice(); } }
	 */
}
