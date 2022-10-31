package com.adrian.exceptions;

public class TicketDoesNotExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TicketDoesNotExistException() {
		super("That ticket cannot be found");
	}

}
