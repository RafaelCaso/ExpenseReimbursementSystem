package com.adrian.exceptions;

public class IncorrectIDOrPasswordException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public IncorrectIDOrPasswordException() {
		super("The employee ID or password entered is incorrect, please try again.");
	}

}
