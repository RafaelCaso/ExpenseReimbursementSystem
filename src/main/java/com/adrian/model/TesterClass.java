package com.adrian.model;

import java.io.Serializable;
import java.util.Arrays;

public class TesterClass implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	private Ticket[] previousTickets;
	
	public TesterClass() {
		
	}

	public TesterClass(String name, String password, Ticket[] previousTickets) {
		super();
		this.name = name;
		this.password = password;
		this.previousTickets = previousTickets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Ticket[] getPreviousTickets() {
		return previousTickets;
	}

	public void setPreviousTickets(Ticket[] previousTickets) {
		this.previousTickets = previousTickets;
	}

	@Override
	public String toString() {
		return "TesterClass [name=" + name + ", password=" + password + ", previousTickets="
				+ Arrays.toString(previousTickets) + "]";
	}
	
	
	
	
	
}
