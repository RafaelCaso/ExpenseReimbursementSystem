package com.adrian.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adrian.model.Employee;
import com.adrian.utils.JDBCConnectionUtil;

public class EmployeeDaoJDBC implements EmployeeDao {
	
	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();

	@Override
	public void addEmployee(Employee e) {
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "INSERT INTO employees(fName, lName, email, password) VALUES ('" 
			+ e.getfName() + "','" 
			+ e.getlName() + "','" 
			+ e.getEmail() + "','" 
			+ e.getPassword() + "')";
			
			Statement statement = connection.createStatement();
			statement.execute(sql);
			
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> eList = new ArrayList<>();
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM employees";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Employee e = new Employee();
				e.setId(result.getInt(1));
				e.setfName(result.getString(2));
				e.setlName(result.getString(3));
				e.setEmail(result.getString(4));
				e.setPassword(result.getString(5));
				
				eList.add(e);
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return eList;
	}

	@Override
	public Employee getEmployeeByID(int id) {
		Employee e = null;
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM employees WHERE id=" + id;
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				e = new Employee();
				e.setId(result.getInt(1));
				e.setfName(result.getString(2));
				e.setlName(result.getString(3));
				e.setEmail(result.getString(4));
				e.setPassword(result.getString(5));
						
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee loginEmployee(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
