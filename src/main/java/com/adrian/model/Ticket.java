package com.adrian.model;



public class Ticket  {

	private int id;
	private String expenseReport;
	private double requestedExpenseAmount;
	private int employeeID;
	private TicketStatus type;

	
	public Ticket() {
		super();
	}
	
	public Ticket(String expenseReport, double requestedExpenseAmount, int employeeID, TicketStatus type) {
		super();
		this.expenseReport = expenseReport;
		this.requestedExpenseAmount = requestedExpenseAmount;
		this.employeeID = employeeID;
		this.type = type;
	}
	
	

	public Ticket(String expenseReport, double requestedExpenseAmount, int employeeID) {
		super();
		this.expenseReport = expenseReport;
		this.requestedExpenseAmount = requestedExpenseAmount;
		this.employeeID = employeeID;
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

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public TicketStatus getType() {
		return type;
	}

	public void setType(TicketStatus type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", expenseReport=" + expenseReport + ", requestedExpenseAmount="
				+ requestedExpenseAmount + ", employeeID=" + employeeID + ", type=" + type + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
