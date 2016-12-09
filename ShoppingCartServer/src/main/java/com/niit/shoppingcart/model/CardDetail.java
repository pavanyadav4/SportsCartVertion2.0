package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
public class CardDetail implements Serializable{
	
	
	private static final long serialVersionUID = 10L;
	@Id
	private String cardDetailId;
	
	private String userId;
	
	@NotBlank(message="Card number must be entered")
	private String cardNumber;
	
	@NotBlank(message="Expiry month must be selected")
	private String expiryMonth;
	
	@NotBlank(message="Expiry year must be selected")
	private String expiryYear;
	
	@NotBlank(message="CVV number must be entered")
	private String cvvNumber;
	
	@NotBlank(message="Name must be entered")
	private String nameOnCard;
	
	private double totalCost;

	/* declare the database column names for Category table... */
	
	public String getCardDetailId() {
		return cardDetailId;
	}
	public void setCardDetailId(String cardDetailId) {
		this.cardDetailId = cardDetailId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	
}