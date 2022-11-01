package com.adrian.model;

import java.io.Serializable;

// pass Employee as argument to Ticket so whenever a ticket is opened it will use the employee ID of the employee who submitted it
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String expenseReport;
	private double requestedExpenseAmount;
	private long employeeID;
//	private String status; will need some kind of functionality to indicate ticket status/acceptance or denial
//	private boolean closed;
	
	public Ticket(String expenseReport, double requestedExpenseAmount, long employeeID) {
		this.expenseReport = expenseReport;
		this.requestedExpenseAmount = requestedExpenseAmount;
		this.employeeID = employeeID;
//		TicketStatus ticketSatus = TicketStatus.PENDING;
	}
	
	public Ticket() {
		
	}

	public String getExpenseReport() {
		return expenseReport;
	}

	public void setExpenseReport(String expenseReport) {
		this.expenseReport = expenseReport;
	}

	public double getRequestedExpenseAmount() {
		return requestedExpenseAmount;
	}

	public void setRequestedExpenseAmount(double requestedExpenseAmount) {
		this.requestedExpenseAmount = requestedExpenseAmount;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Ticket [expenseReport=" + expenseReport + ", requestedExpenseAmount=" + requestedExpenseAmount
				+ ", employeeID=" + employeeID + "]";
	}
	
	
	
	

}
