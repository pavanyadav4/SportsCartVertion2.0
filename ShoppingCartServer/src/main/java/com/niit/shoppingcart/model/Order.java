package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="OrderDetail")
public class Order implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;

	/* declare the database column names for Order table... */
	
	@Id
	private String orderId;
	
	private String userId;
	
	private double grandTotal;
	
	@Column
	private String billingAddressId;

	public Order() {
		this.orderId = "OD" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
	/* getters/setters for all the fields taken... */

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}	
}