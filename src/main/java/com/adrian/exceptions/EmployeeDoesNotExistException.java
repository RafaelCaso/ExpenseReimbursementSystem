package com.adrian.exceptions;

public class EmployeeDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeDoesNotExistException() {
		super("The employee ID entered does not match any employee on file.");
	}
}
