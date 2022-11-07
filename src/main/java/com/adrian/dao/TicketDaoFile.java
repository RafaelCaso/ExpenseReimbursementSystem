package com.adrian.dao;

import java.util.ArrayList;
import java.util.List;

import com.adrian.exceptions.TicketDoesNotExistException;
import com.adrian.model.Ticket;

public class TicketDaoFile implements TicketDao {
	
	private FileIO<List<Ticket>> io;
	
	public TicketDaoFile() {
		this.io = new FileIO<List<Ticket>>("tickets.txt");
	}

	@Override
	public void addTicket(Ticket t) {
		List<Ticket> tList = io.readObject();
		if(tList == null) {
			tList = new ArrayList<>();
		}
		
		tList.add(t);
		io.writeObject(tList);
		
	}

	@Override
	public List<Ticket> getAllTickets() {
		List<Ticket> tList = io.readObject();
		if(tList == null) {
			tList = new ArrayList<>();
		}
		return tList;
	}

	@Override
	public List<Ticket> getTicketByEmployeeID(int id) {
		List<Ticket> tList = io.readObject();
		if(tList == null) {
			tList = new ArrayList<>();
		}
		for(Ticket t: tList) {
			if(t.getEmployeeID() == id) {
				return tList;
			}
		}
		
		throw new TicketDoesNotExistException();
	}

	@Override
	public void updateTicket(Ticket t) {
		List<Ticket> tList = io.readObject();
		if(tList == null) {
			tList = new ArrayList<>();
		}
		for(int i = 0; i < tList.size(); i++) {
			if(tList.get(i).getEmployeeID() == t.getEmployeeID()) {
				tList.remove(i);
				tList.add(t);
				return;
			}
		}
		throw new TicketDoesNotExistException();
		
	}

	@Override
	public List<Ticket> getAllPending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveTicket(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void declineTicket(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ticket getTicketByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getAllApproved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getAllDeclined() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> gettAllApprovedById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> gettAllDeclinedById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> gettAllPendingById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
