package com.adrian.dao;

import java.util.List;

import com.adrian.model.Ticket;

public interface TicketDao {

	public void addTicket(Ticket t);
	public List<Ticket> getAllTickets();
	public List<Ticket> getTicketByEmployeeID(int id);
	// public void deleteTicket (Not sure there should be an option to delete tickets)
	public void updateTicket(Ticket t);
	public List<Ticket> getAllPending();
	public void approveTicket(int id);
	public void declineTicket(int id);
	public Ticket getTicketByID(int id);
	public List<Ticket> getAllApproved();
	public List<Ticket> getAllDeclined();
	public List<Ticket> gettAllPendingById(int id);
	public List<Ticket> gettAllApprovedById(int id);
	public List<Ticket> gettAllDeclinedById(int id);
	
	
}
