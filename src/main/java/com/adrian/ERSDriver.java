package com.adrian;

import com.adrian.controller.EmployeeController;
import com.adrian.controller.TicketController;
import com.adrian.dao.EmployeeDao;
import com.adrian.dao.EmployeeDaoFile;
import com.adrian.dao.FileIO;
import com.adrian.dao.TicketDao;
import com.adrian.dao.TicketDaoFile;
import com.adrian.model.Ticket;
import com.adrian.service.EmployeeService;
import com.adrian.service.TicketService;

import io.javalin.Javalin;

public class ERSDriver {
	
	public static void main(String[] args) {
		TicketDao tDao = new TicketDaoFile();
		TicketService tServ = new TicketService(tDao);
		TicketController tCon = new TicketController(tServ);
		
		EmployeeDao eDao = new EmployeeDaoFile();
		EmployeeService eServ = new EmployeeService(eDao);
		EmployeeController eCon = new EmployeeController(eServ);
		
		Javalin app = Javalin.create();
		
		app.post("/ticket/register/", tCon.handleRegister);
		app.get("/ticket/", tCon.handleGetAll);
		
		app.post("/employee/register/", eCon.handleRegister);
		app.get("/employee/", eCon.handleGetAll);
		app.delete("/employee/delete", eCon.handleDelete);
		
		
		app.start(8000);
		
		
				
	}

}
