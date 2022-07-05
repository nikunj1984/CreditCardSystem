package com.sapient.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.creditcard.model.CreditCard;
import com.sapient.creditcard.service.CreditCardService;

@RestController
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard card) {
		return new ResponseEntity<>(creditCardService.createNewCard(card), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<CreditCard>> getAllCreditCard() {
		return new ResponseEntity<>(creditCardService.getAllCards(), HttpStatus.OK);
	}
}
