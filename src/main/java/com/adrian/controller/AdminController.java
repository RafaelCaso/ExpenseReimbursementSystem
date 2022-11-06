package com.adrian.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.adrian.model.Admin;
import com.adrian.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Handler;

public class AdminController {

	private AdminService adServ;
	private ObjectMapper objectMapper;
	
	public AdminController(AdminService adServ) {
		this.adServ = adServ;
		objectMapper = new ObjectMapper();
	} 
	
	public Handler handleRegisterAdmin = (context)  -> {
		Admin admin = objectMapper.readValue(context.body(), Admin.class);
		adServ.registerAdmin(admin);
		
		context.status(201);
		context.result(objectMapper.writeValueAsString(admin));
	};
	
	public Handler handleGetAll = (context) -> {
		List<Admin> aList = adServ.getAllAdmins();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(aList));
	};
	
	public Handler handleDelete = (context) -> {
		Admin a = objectMapper.readValue(context.body(), Admin.class);
		adServ.deleteAdmin(a);
		
		context.status(200);
		context.result("Admin removed from database");
	};
	
	public Handler handleGetAdminById = (context) -> {
		HashMap<String, Integer> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		Admin a = adServ.getAdminById(body.get("id"));
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(a));
	};
	
}
