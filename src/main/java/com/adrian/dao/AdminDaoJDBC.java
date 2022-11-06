package com.adrian.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adrian.model.Admin;
import com.adrian.utils.JDBCConnectionUtil;

public class AdminDaoJDBC implements AdminDao {
	
	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();

	@Override
	public void addAdmin(Admin a) {
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "INSERT INTO admins(fname, lname, email, password) VALUES ('" 
					+ a.getfName() + "', '" 
					+ a.getlName() + "', '" 
					+ a.getEmail() + "','" 
					+ a.getPassword() + "')";
			
			Statement statement = connection.createStatement();
			statement.execute(sql);
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> aList = new ArrayList<>();
		
		try {
		Connection connection = conUtil.getConnection();	
		String sql = "SELECT * FROM admins";
		
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()) {
			Admin a = new Admin();
			
			a.setId(result.getInt(1));
			a.setfName(result.getString(2));
			a.setlName(result.getString(3));
			a.setEmail(result.getString(4));
			a.setPassword(result.getString(5));
			
			aList.add(a);
		}
		
		
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return aList;
	}

	@Override
	public Admin getAdminByID(int id) {
		Admin a = null;
		
		try {
			
			Connection connection = conUtil.getConnection();
			String sql = "SELECT * FROM admins WHERE id=" + id;
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				a = new Admin();
				
				a.setId(result.getInt(1));
				a.setfName(result.getString(2));
				a.setlName(result.getString(3));
				a.setEmail(result.getString(4));
				a.setPassword(result.getString(5));
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return a;
	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAdmin(Admin a) {
		// TODO Auto-generated method stub
		
	}
	
	

}
