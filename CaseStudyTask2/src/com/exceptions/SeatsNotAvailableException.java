package com.exceptions;

public class SeatsNotAvailableException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5857826357929796111L;

	public SeatsNotAvailableException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
