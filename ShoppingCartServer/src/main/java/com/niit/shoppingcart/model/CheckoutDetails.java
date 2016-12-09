package com.niit.shoppingcart.model;

import java.io.Serializable;

public class CheckoutDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	
	private CardDetail cardDetail;
	private ShippingAddress shippingAddress;
	private OrderDetail orderDetail;
	private Cart cart;
	private UserDetails userdetails;
	
	/* getters/setters for all the fields taken... */
	
	public CardDetail getCardDetail() {
		return cardDetail;
	}
	public void setCardDetail(CardDetail cardDetail) {
		this.cardDetail = cardDetail;
	}
	
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public UserDetails getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}
	
}
