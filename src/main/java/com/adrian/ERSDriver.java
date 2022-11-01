package com.adrian;

import com.adrian.controller.AdminController;
import com.adrian.controller.EmployeeController;
import com.adrian.controller.TicketController;
import com.adrian.dao.AdminDao;
import com.adrian.dao.AdminDaoFile;
import com.adrian.dao.EmployeeDao;
import com.adrian.dao.EmployeeDaoFile;
import com.adrian.dao.FileIO;
import com.adrian.dao.TicketDao;
import com.adrian.dao.TicketDaoFile;
import com.adrian.model.Ticket;
import com.adrian.service.AdminService;
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
		
		AdminDao adDao = new AdminDaoFile();
		AdminService adServ = new AdminService(adDao);
		AdminController adCon = new AdminController(adServ);
		
		Javalin app = Javalin.create();
		
		app.post("/ticket/register/", tCon.handleRegister);
		app.get("/ticket/", tCon.handleGetAll);
		
		app.post("/employee/register/", eCon.handleRegister);
		app.get("/employee/", eCon.handleGetAll);
		app.delete("/employee/delete", eCon.handleDelete);
		
		app.post("/admin/register/", adCon.handleRegisterAdmin);
		app.get("/admin/", adCon.handleGetAll);
		app.delete("/admin/delete/", adCon.handleDelete);
		
		
		app.start(8000);
		
		
				
	}

}
