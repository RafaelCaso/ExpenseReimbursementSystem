package com.adrian.model;

import java.io.Serializable;
import java.util.Arrays;

public class Employee implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private int employeeID;
	private String fName;
	private String lName;
	private String email;
	private String password;
	
	public Employee() {
		
	}
	
	public Employee(int employeeID, String fName, String lName, String email, String password) {
		this.employeeID = employeeID;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	

}
