package com.sapient.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.creditcard.model.CreditCard;

public interface CardRepository extends JpaRepository<CreditCard, Long>{

	public CreditCard findByCardNumber(String cardNumber);
}
