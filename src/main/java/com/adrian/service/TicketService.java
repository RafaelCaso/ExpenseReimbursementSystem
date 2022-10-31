package com.adrian.service;

import java.util.List;

import com.adrian.dao.TicketDao;
import com.adrian.exceptions.TicketDoesNotExistException;
import com.adrian.model.Ticket;

public class TicketService {
	
	private TicketDao ticketDao;
	
	public TicketService(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	public void submitTicket(Ticket t) {
		try {
			ticketDao.getTicketByEmployeeID(t.getEmployeeID());
		} catch(TicketDoesNotExistException e) {
			ticketDao.addTicket(t);
		}
	}
	
	public List<Ticket> getAllSubmittedTicket() {
		
		return ticketDao.getAllTickets();
		
	}
	
}
