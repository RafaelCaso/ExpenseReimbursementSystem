package com.adrian.dao;

import java.util.List;

import com.adrian.model.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeByID(int id);
	public void deleteEmployee(int id);
	public void updateEmployee(Employee e);
	public Employee loginEmployee(int id, String password);
	

}
