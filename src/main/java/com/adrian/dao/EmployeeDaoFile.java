package com.adrian.dao;

import java.util.ArrayList;
import java.util.List;

import com.adrian.exceptions.EmployeeDoesNotExistException;
import com.adrian.exceptions.EmployeeIDAlreadyExistsException;
import com.adrian.exceptions.IncorrectIDOrPasswordException;
import com.adrian.model.Employee;

public class EmployeeDaoFile implements EmployeeDao {
	
	private FileIO<List<Employee>> io;
	
	public EmployeeDaoFile() {
		this.io = new FileIO<List<Employee>>("employees.txt");
	}

	@Override
	public void addEmployee(Employee e) {
		List<Employee> eList = io.readObject();
		if(eList == null) {
			eList = new ArrayList<>();
		}
		
		// this check for existing employee throws a ConcurrentModificationException
		// functionally it works (it won't add employee if ID is already used and will add to file if employee ID is available but it throws a server error 500)
		for(Employee employee : eList) {
			if(employee.getId() == e.getId()) {
				throw new EmployeeIDAlreadyExistsException();  
			} else {
				eList.add(e);
				io.writeObject(eList);
			}
		}
		
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> eList = io.readObject();
		if(eList == null) {
			eList = new ArrayList<>();
		}
		return eList;
	}

	@Override
	public Employee getEmployeeByID(int id) {
		List<Employee> eList = io.readObject();
		if(eList == null) {
			eList = new ArrayList<>();
		}
		
		for(Employee e : eList) {
			if(e.getId() == id) {
				return e;
			}
		}
		 throw new EmployeeDoesNotExistException();
	}

	@Override
	public void deleteEmployee(int id) {
		List<Employee> eList = io.readObject();
		if(eList == null) {
			eList = new ArrayList<>();
		}
		
		for(int i = 0; i < eList.size(); i++) {
			if(eList.get(i).getId() == id) {
				eList.remove(i);
				return;
			}
		}
		
		throw new EmployeeDoesNotExistException();
	}

	@Override
	public void updateEmployee(Employee e) {
		List<Employee> eList = io.readObject();
		if(eList == null) {
			eList = new ArrayList<>();
		}
		
		for(int i = 0; i < eList.size(); i++) {
			if(eList.get(i).getId() == e.getId()) {
				eList.remove(i);
				eList.add(e);
			}
		}
		throw new EmployeeDoesNotExistException();
	}

	@Override
	public Employee loginEmployee(int id, String password) {
		List<Employee> eList = io.readObject();
		if(eList == null) {
			eList = new ArrayList<>();
		}
		
		for(int i = 0; i < eList.size(); i++) {
			System.out.println(eList.get(i).getfName());
			System.out.println(eList.get(i).getId());
			System.out.println(eList.get(i).getPassword());
			if(eList.get(i).getId() == id && eList.get(i).getPassword() == password) {
				return eList.get(i);
			}
		}
		return null;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
