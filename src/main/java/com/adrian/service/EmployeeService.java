package com.adrian.service;

import java.util.List;

import com.adrian.dao.EmployeeDao;
import com.adrian.exceptions.EmployeeDoesNotExistException;
import com.adrian.model.Employee;

public class EmployeeService {
	
	private EmployeeDao employeeDao;
	
	public EmployeeService(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void registerEmployee(Employee e) {
		
		try {
			employeeDao.getEmployeeByID(e.getEmployeeID());
		} catch(EmployeeDoesNotExistException ex) {
			employeeDao.addEmployee(e);
		}
	}
	
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	
	public void deleteEmployee(Employee e) {
		try {
			employeeDao.deleteEmployee(e.getEmployeeID());
		} catch(EmployeeDoesNotExistException ex) {
			return;
		}
	}
	
}	
