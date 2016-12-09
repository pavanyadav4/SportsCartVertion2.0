package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Component
public class BillingAddress implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;

	@Id
	@Column
	private String billingAddressId;
		
	private String userId;
	
	@NotEmpty(message="Specify main address")
	private String line1;
	
	@NotEmpty
	private String line2;

	@NotEmpty(message="Specify city")
	private String city;
	
	@NotEmpty(message="Specify state")
	private String state;
	
	@NotEmpty(message="Specify country")
	private String country;
	
	@NotEmpty(message="Specify zipcode")
	private String zipCode;

	public BillingAddress() {
		this.billingAddressId = "BILL" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
	/* getters/setters for all the fields taken... */

	public String getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}