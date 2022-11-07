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
		ticketDao.addTicket(t);	
	}
	
	public List<Ticket> getAllSubmittedTicket() {
		
		return ticketDao.getAllTickets();
		
	}
	
	public List<Ticket>getTicketByEmployeeId(int id) {
		return ticketDao.getTicketByEmployeeID(id);
	}
	
	public List<Ticket> getAllPending() {
		return ticketDao.getAllPending();
	}
	
	public void approveTicket(int id) {
		ticketDao.approveTicket(id);
	}
	
	public void declineTicket(int id) {
		ticketDao.declineTicket(id);
	}
	
	public Ticket getTicketByID(int id) {
		return ticketDao.getTicketByID(id);
	}
	
}
