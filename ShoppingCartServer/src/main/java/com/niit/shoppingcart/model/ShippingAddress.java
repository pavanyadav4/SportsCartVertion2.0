package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
public class ShippingAddress implements Serializable {
	
	private static final long serialVersionUID = 10L;
	
	@Id
	private String shipId;
	
	private String userId;
	
	@NotBlank(message="Specify main address")	
	private String address;	
	
	@NotBlank(message="Specify city")
	private String city;
	
	@NotBlank(message="Specify state")
	private String state;
	
	@NotBlank(message="Specify zipcode")
	private String zipCode;
	
	/* getters/setters for all the fields taken... */

	public String getShipId() {
		return shipId;
	}
	public void setShipId(String shipId) {
		this.shipId = shipId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}	
}
