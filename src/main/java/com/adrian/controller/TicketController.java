package com.adrian.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.adrian.model.Ticket;
import com.adrian.model.TicketStatus;
import com.adrian.service.TicketService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Handler;

public class TicketController {
	
	private TicketService tServ;
	private ObjectMapper objectMapper;
	
	public TicketController(TicketService tServ) {
		this.tServ = tServ;
		objectMapper = new ObjectMapper();
	}
	
	public Handler handleRegister = (context) -> {
		Ticket ticket = objectMapper.readValue(context.body(), Ticket.class);
		tServ.submitTicket(ticket);
		
		context.status(201);
		context.result(objectMapper.writeValueAsString(ticket));		
	};
	
	public Handler handleGetAll = (context) -> {
		List<Ticket> tList = tServ.getAllSubmittedTicket();
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
	};
	
	public Handler handleGetTicketByEmployeeId = (context) -> {
		HashMap<String, Integer> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		List<Ticket> tList = tServ.getTicketByEmployeeId(body.get("id"));
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
	};
	
	public Handler handleGetAllPending = (context) -> {
		List<Ticket> tList = tServ.getAllPending();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
	};
	
	public Handler handleApproveTicket = (context) -> {
		HashMap<String, Integer> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		Ticket checkTicket = tServ.getTicketByID(body.get("id"));
		if(checkTicket.getType().equals(TicketStatus.PENDING)) {
			tServ.approveTicket(body.get("id"));
			context.status(200);
			context.result("Ticket " + body.get("id") +  " has been approved");
			return;
		}
		
		context.status(400);
		context.result("Sorry, that ticket is no longer pending.");		
		
	};
	
	public Handler handleDeclineTicket = (context) -> {
		
		HashMap<String, Integer> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		Ticket checkTicket = tServ.getTicketByID(body.get("id"));
		if(checkTicket.getType().equals(TicketStatus.PENDING)) {
			
			tServ.declineTicket(body.get("id"));
			context.status(200);
			context.result("Ticket " + body.get("id") + " has been declined");
			return;
		}
		
		context.status(400);
		context.result("Sorry, that ticket is no longer pending.");	
		
	};
	
	public Handler handleGetAllApproved = (context) -> {
		List<Ticket> tList = tServ.getAllApproved();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
		
	};
	
	public Handler handleGetAllDeclined = (context) -> {
		List<Ticket> tList = tServ.getAllDeclined();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
	};
	
	public Handler handleGetAllPendingdById = (context) -> {
		HashMap<String, Integer> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		Integer id = body.get("id");
		List<Ticket> tList = tServ.getAllPendingById(id);
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
		
	};
	
	public Handler handleGetAllApprovedById = (context) -> {
		HashMap<String, Integer> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		Integer id = body.get("id");
		List<Ticket> tList = tServ.getAllApprovedById(id);
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
		
	};
	
	public Handler handleGetAllDeclinedById = (context) -> {
		HashMap<String, Integer> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		Integer id = body.get("id");
		List<Ticket> tList = tServ.getAllDeclinedById(id);
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
	};
	
	

}
