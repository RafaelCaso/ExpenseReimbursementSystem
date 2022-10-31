package com.adrian.dao;

import java.util.List;

import com.adrian.model.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeByID(long id);
	public void deleteEmployee(long id);
	public void updateEmployee(Employee e);
	

}
