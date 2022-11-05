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
		employeeDao.addEmployee(e);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	
	public void deleteEmployee(Employee e) {
		try {
			employeeDao.deleteEmployee(e.getId());
		} catch(EmployeeDoesNotExistException ex) {
			return;
		}
	}
	
	public Employee getEmployee(int id, String password) {
		return employeeDao.loginEmployee(id, password);
	}
	
	public Employee getEmployeeById(int id) {
		return employeeDao.getEmployeeByID(id);
	}
	
	
	
	
	
}	
