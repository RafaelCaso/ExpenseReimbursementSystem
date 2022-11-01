package com.adrian.model;

import java.io.Serializable;

public class Admin implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private int adminID;
	private String fName;
	private String lName;
	private String email;
	private String password;
		
	public Admin() {
		
	}
	
	public Admin(int adminID, String fName, String lName, String email, String password) {
		this.adminID = adminID;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
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
		return "Admin [adminID=" + adminID + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	
	

}
