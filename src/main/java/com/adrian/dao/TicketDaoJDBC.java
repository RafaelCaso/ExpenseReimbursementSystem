package com.adrian.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adrian.model.Ticket;
import com.adrian.model.TicketStatus;
import com.adrian.utils.JDBCConnectionUtil;

public class TicketDaoJDBC implements TicketDao {

	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();
	
	@Override
	public void addTicket(Ticket t) {
		try {
			
			Connection connection = conUtil.getConnection();
			int type = (t.getType().ordinal() + 1);
			String sql = "INSERT INTO tickets(expensereport, requestedexpenseamount, employeeid, type) VALUES (' " 
					+ t.getExpenseReport() + "', " 
					+ t.getRequestedExpenseAmount() + ", " 
					+ t.getEmployeeID() + ", " 
					+ type + ")";
			
			Statement statement = connection.createStatement();
			statement.execute(sql);
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<Ticket> getAllTickets() {
		
		List<Ticket> tList = new ArrayList<>();
		
		try {
			
			Connection connection = conUtil.getConnection();
			String sql = "SELECT * FROM tickets";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Ticket t = new Ticket();
				
				t.setId(result.getInt(1));
				t.setExpenseReport(result.getString(2));
				t.setRequestedExpenseAmount(result.getDouble(3));
				t.setEmployeeID(result.getInt(4));
				if(result.getInt(5) == 1) {
					t.setType(TicketStatus.PENDING);
				} else if(result.getInt(5) == 2) {
					t.setType(TicketStatus.OPEN);
				} else {
					t.setType(TicketStatus.CLOSED);
				}
				tList.add(t);
				
				
			}
			
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return tList;
	}

	@Override
	public List<Ticket> getTicketByEmployeeID(int id) {
		
		List<Ticket> tList = new ArrayList<>();
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM tickets WHERE employeeid = " + id;
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Ticket t = new Ticket();
				
				t.setId(result.getInt(1));
				t.setExpenseReport(result.getString(2));
				t.setRequestedExpenseAmount(result.getDouble(3));
				t.setEmployeeID(result.getInt(4));
				if(result.getInt(5) == 1) {
					t.setType(TicketStatus.PENDING);
				} else if(result.getInt(5) == 2) {
					t.setType(TicketStatus.OPEN);
				} else {
					t.setType(TicketStatus.CLOSED);
				}
				tList.add(t);
				
				
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return tList;
	}

	@Override
	public void updateTicket(Ticket t) {
		
		
	}

}
