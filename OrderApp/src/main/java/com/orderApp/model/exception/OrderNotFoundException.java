package com.orderApp.model.exception;

public class OrderNotFoundException extends RuntimeException{

	/**
	 * DEFAULT SERIAL VERSION ID
	 */
	private static final long serialVersionUID = 1L;

	/**************ORDER NOT FOUND EXCEPTION*********************************/
	public OrderNotFoundException(String message) {
		super(message);
	}
	
}
