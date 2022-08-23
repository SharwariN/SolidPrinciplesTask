package com.exceptions;

public class InvalidSeatNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3931751623878130582L;

	public InvalidSeatNumberException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
