package com.sapient.creditcard.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7580065014588447747L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@NotNull(message = "Name cannot be null")
	private String name;
	
	@NotNull(message = "Card Number cannot be null")
	@Column(name = "card_number")
	private String cardNumber;
	
	@NotNull(message = "Limit cannot be null")
	@Column(name = "card_limit")
	private Integer limit;
	
	private Double balance;		
	
	public CreditCard() {}
	
	


	public CreditCard(Long id, @NotNull(message = "Name cannot be null") String name,
			@NotNull(message = "Card Number cannot be null") String cardNumber,
			@NotNull(message = "Limit cannot be null") Integer limit, Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.cardNumber = cardNumber;
		this.limit = limit;
		this.balance = balance;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public Integer getLimit() {
		return limit;
	}


	public void setLimit(Integer limit) {
		this.limit = limit;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, cardNumber, id, limit, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(cardNumber, other.cardNumber)
				&& Objects.equals(id, other.id) && Objects.equals(limit, other.limit)
				&& Objects.equals(name, other.name);
	}




	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", name=" + name + ", cardNumber=" + cardNumber + ", limit=" + limit
				+ ", balance=" + balance + "]";
	}

	
	
}
