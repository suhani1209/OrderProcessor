package com.orderapp.model.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * DEFAULT SERIAL VERSION ID
	 */
	private static final long serialVersionUID = 1L;

	//USER NOT FOUND EXCEPTION
	public UserNotFoundException(String message) {
		super(message);
	}

}
