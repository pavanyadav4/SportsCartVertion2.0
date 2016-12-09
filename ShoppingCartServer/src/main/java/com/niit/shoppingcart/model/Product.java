package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Entity		//specify that it is an entity...   **java class that mapped to a db table...
@Table		//if table name and domain class name is same, then no need to specify name here...
@Component		//@Component annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context..
public class Product {
	
	/* declare the database column names for Product table... */
	
	@Id
	@Size(min = 6, max = 10, message = "Id should contain 6-10 characters")
	private String id;
	
	@NotEmpty(message = "Name field can not be blank")
	@Size(min = 3 , message = "Name contains atleast 3 character")
	private String name;
	
	@NotEmpty(message = "Description field can not be blank")
	@Size(min = 5 , message = "description contains atleast 5 characters")
	private String description;
		
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "supplierId")
	Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	Category category;
	
	@Transient
	private MultipartFile file;
	
	private String productImage;
	
	
	/* getters/setters for all the fields taken... */

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	


	
}
