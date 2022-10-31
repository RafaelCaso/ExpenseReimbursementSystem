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
	public Ticket getTicketByEmployeeID(long id) {
		List<Ticket> tList = io.readObject();
		if(tList == null) {
			tList = new ArrayList<>();
		}
		for(Ticket t: tList) {
			if(t.getEmployeeID() == id) {
				return t;
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

}
