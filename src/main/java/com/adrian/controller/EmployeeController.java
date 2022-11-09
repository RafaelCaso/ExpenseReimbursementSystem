package com.adrian.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.adrian.model.Employee;
import com.adrian.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Handler;

public class EmployeeController {
	
	private EmployeeService eServ;
	private ObjectMapper objectMapper;
	
	public EmployeeController(EmployeeService eServ) {
		this.eServ = eServ;
		objectMapper = new ObjectMapper();
	}
	
	public Handler handleRegister = (context) -> {
		Employee employee = objectMapper.readValue(context.body(), Employee.class);
		
		List<Employee> tList = eServ.getAllEmployees();
		for(Employee searchEmployee : tList) {
			if(searchEmployee.getEmail().toLowerCase().equals(employee.getEmail().toLowerCase())) {
				context.status(400);
				context.result("That email is not available. Please try again");
				return;
			} 
		}
		
		eServ.registerEmployee(employee);
		
		context.status(201);
		context.result("Welcome " + employee.getfName() + "! You are now registered in the company's Expense Reimbursement System.");
		
	};
	
	public Handler handleGetAll = (context) -> {
		List<Employee> eList = eServ.getAllEmployees();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(eList));
	};
	
	public Handler handleDelete = (context) -> {
		Employee e = objectMapper.readValue(context.body(), Employee.class);
		eServ.deleteEmployee(e);
		
		context.status(200);
		context.result("Employee removed from database");
	};
	
	public Handler handleGetEmployeeById = (context) -> {
		HashMap<String, Integer> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		Employee e = eServ.getEmployeeById(body.get("id"));
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(e));			
	};
	
	public Handler handleLogin = (context) -> {
		HashMap<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		Employee e = eServ.loginEmployee(body.get("email").toLowerCase(), body.get("password"));
		
		if(e == null) {
			context.status(401);
			context.result("The email or password you used was incorrect. Please try again.");
		} else {
			context.status(200);
			context.result("Hello " + e.getfName() + ", you are now logged in");
		}
		
		
	};
	

	

}
