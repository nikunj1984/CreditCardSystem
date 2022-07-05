package com.sapient.creditcard.service.impl;

import static com.sapient.creditcard.util.ValidationUtil.isValidCreditCardNumber;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.creditcard.exception.InvalidCardException;
import com.sapient.creditcard.model.CreditCard;
import com.sapient.creditcard.repository.CardRepository;
import com.sapient.creditcard.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CardRepository repository;
	
	@Override
	public CreditCard createNewCard(CreditCard card) {
		if(isValidCreditCardNumber(card.getCardNumber())) {
			CreditCard savedCard = repository.findByCardNumber(card.getCardNumber());
			if(savedCard==null) {
				return repository.save(card);
			} else {
				throw new InvalidCardException("Credit Card :"+ card.getCardNumber() + "already exists!!");
			}
			
		} else {
			throw new InvalidCardException("Invalid Credit Card Number!!");
		}
		
	}

	@Override
	public List<CreditCard> getAllCards() {
		return repository.findAll();
	}

}
