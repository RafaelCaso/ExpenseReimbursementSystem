package com.adrian.exceptions;

public class AdminDoesNotExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AdminDoesNotExistException() {
		super("There is no Admin with that ID");
	}
}
