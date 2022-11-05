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
		eServ.registerEmployee(employee);
		
		context.status(201);
		context.result(objectMapper.writeValueAsString(employee));
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
	

	

}
