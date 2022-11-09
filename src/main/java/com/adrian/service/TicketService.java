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
	
	public boolean submitTicket(Ticket t) {
		if(t.getExpenseReport() == "" || t.getRequestedExpenseAmount() <= 0){
			return false;
		}
		ticketDao.addTicket(t);	
		return true;
	}
	
	public List<Ticket> getAllSubmittedTicket() {
		
		return ticketDao.getAllTickets();
		
	}
	
	public List<Ticket>getTicketByEmployeeId(int id) {
		return ticketDao.getTicketByEmployeeID(id);
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
	
	public List<Ticket> getAllPending() {
		return ticketDao.getAllPending();
	}
	
	public List<Ticket> getAllApproved(){
		return ticketDao.getAllApproved();
	}
	
	public List<Ticket> getAllDeclined(){
		return ticketDao.getAllDeclined();
	}
	
	
	
	public List<Ticket> getAllPendingById(int id){
		return ticketDao.gettAllPendingById(id);
	}
	
	public List<Ticket> getAllApprovedById(int id){
		return ticketDao.gettAllApprovedById(id);
	}
	
	public List<Ticket> getAllDeclinedById(int id){
		return ticketDao.gettAllDeclinedById(id);
	}
}
