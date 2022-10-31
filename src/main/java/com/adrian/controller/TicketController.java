package com.adrian.controller;

import java.util.List;

import com.adrian.model.Ticket;
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

}
