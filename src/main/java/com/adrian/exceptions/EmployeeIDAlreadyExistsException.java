package com.adrian.exceptions;

public class EmployeeIDAlreadyExistsException extends RuntimeException {
	
	public EmployeeIDAlreadyExistsException() {
		super("That employee ID is already in use. Please resubmit with a new, unique, employee ID");
	}
	
}
