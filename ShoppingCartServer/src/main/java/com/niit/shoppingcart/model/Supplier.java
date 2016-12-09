package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity		//specify that it is an entity...		**java class that mapped to a db table...
@Table		//if table name and domain class name is same, then no need to specify name here...
@Component		//@Component annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context..
public class Supplier {
	
		/* declare the database column names for Supplier table... */
	
	@Id
	@Column(name="supplierId")
	@Size(min = 6, max = 10, message = "Id should contain 6-10 characters")
	private String id;
	
	@NotEmpty(message = "Name field can not be blank")
	@Size(min = 3 , message = "Name contains atleast 3 character")
	private String name;
	
	@NotEmpty(message = "Address field can not be blank")
	private String address;
	
	@OneToMany( mappedBy="supplier",fetch=FetchType.EAGER)
	Set<Product> products;
		
		/* getters/setters for all the fields taken... */
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
