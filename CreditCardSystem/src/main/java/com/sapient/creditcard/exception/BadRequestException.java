package com.sapient.creditcard.exception;

public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1169173048046677152L;

	public BadRequestException(String message) {
		super(message);
	}
}
