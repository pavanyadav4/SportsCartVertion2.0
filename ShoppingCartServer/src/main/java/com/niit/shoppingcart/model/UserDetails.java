package com.niit.shoppingcart.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "User")
@Component
public class UserDetails implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	
	/* declare the database column names for Product table... */
	
	@Id
	@Size(min = 6, max = 10, message = "Id should contain 6-10 characters")
	private String id;
	
	@NotNull(message = "Name field can not be blank")
	@Size(min=5, max=25, message="Your name should be between 5 - 25 characters.")
	private String name;
	
	@NotNull(message="Please select a password")
	@Length(min=5, max=10, message="Password should be between 5 - 10 charactes")
	private String password;
	
	@NotNull(message = "Address field can not be blank")
	private String address;
	
	@Pattern(regexp="(^$|[0-9]{10})", message = "Please provide a valid phone no.")
	private String phone;

	@Email(message="Please provide a valid email address")
	private String email;
	
	private String role;
	
	private boolean enabled;
	
	/* getters/setters for all the fields taken... */
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

	
}
