package com.sapient.creditcard.exception;

public class InvalidCardException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1169173048046677152L;

	public InvalidCardException(String message) {
		super(message);
	}
}
