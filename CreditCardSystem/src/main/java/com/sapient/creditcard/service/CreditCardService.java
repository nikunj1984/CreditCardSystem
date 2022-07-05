package com.sapient.creditcard.service;

import java.util.List;

import com.sapient.creditcard.model.CreditCard;

public interface CreditCardService {

	public CreditCard createNewCard(CreditCard hotel);
	
	public List<CreditCard> getAllCards();
}
