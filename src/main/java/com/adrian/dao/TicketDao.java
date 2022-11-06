package com.adrian.dao;

import java.util.List;

import com.adrian.model.Ticket;

public interface TicketDao {

	public void addTicket(Ticket t);
	public List<Ticket> getAllTickets();
	public List<Ticket> getTicketByEmployeeID(int id);
	// public void deleteTicket (Not sure there should be an option to delete tickets)
	public void updateTicket(Ticket t);
	
	
	
	
}
