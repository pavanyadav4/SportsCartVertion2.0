package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Category {
	
	
/*@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	public Set<Product> getProducts(){
		return  products;
	}
	public void SetProducts(Set<Product> products){
		this.products=products;
	}
	*/
	
	@Id
	private String id;
	private String name;
	@NotEmpty
	private String description;
	/*private Set<Product> products;*/
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

/*--------------------------------------------------------------*/

