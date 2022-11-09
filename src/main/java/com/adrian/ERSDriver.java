package com.adrian;

import com.adrian.controller.AdminController;
import com.adrian.controller.EmployeeController;
import com.adrian.controller.TicketController;
import com.adrian.dao.AdminDao;
import com.adrian.dao.AdminDaoFile;
import com.adrian.dao.AdminDaoJDBC;
import com.adrian.dao.EmployeeDao;
import com.adrian.dao.EmployeeDaoFile;
import com.adrian.dao.EmployeeDaoJDBC;
import com.adrian.dao.FileIO;
import com.adrian.dao.TicketDao;
import com.adrian.dao.TicketDaoFile;
import com.adrian.dao.TicketDaoJDBC;
import com.adrian.model.Employee;
import com.adrian.model.Ticket;
import com.adrian.service.AdminService;
import com.adrian.service.EmployeeService;
import com.adrian.service.TicketService;

import io.javalin.Javalin;

public class ERSDriver {
	
	public static void main(String[] args) {
		
		// Tickets 
		TicketDao tDao = new TicketDaoJDBC();
		TicketService tServ = new TicketService(tDao);
		TicketController tCon = new TicketController(tServ);
		
		// Employees
		EmployeeDao eDao = new EmployeeDaoJDBC();
		EmployeeService eServ = new EmployeeService(eDao);
		EmployeeController eCon = new EmployeeController(eServ);
		
		
		
		// Admin
		AdminDao adDao = new AdminDaoJDBC();
		AdminService adServ = new AdminService(adDao);
		AdminController adCon = new AdminController(adServ);
		
		Javalin app = Javalin.create();
		
		//Ticket API endpoints
		app.post("/ticket/register/", tCon.handleRegister);
		app.get("/ticket/", tCon.handleGetAll);
		app.get("/ticketbyid", tCon.handleGetTicketByEmployeeId);
		app.get("/ticket/pending", tCon.handleGetAllPending);
		// change approve and decline to patch
		app.patch("/ticket/approve", tCon.handleApproveTicket);
		app.patch("/ticket/decline", tCon.handleDeclineTicket);
		app.get("/ticket/approved", tCon.handleGetAllApproved);
		app.get("/ticket/declined", tCon.handleGetAllDeclined);
		app.get("/ticket/pendingbyid", tCon.handleGetAllPendingdById);
		app.get("/ticket/approvedbyid", tCon.handleGetAllApprovedById);
		app.get("/ticket/declinedbyid", tCon.handleGetAllDeclinedById);
		
		// Employee API Endpoints
		app.post("/employee/register/", eCon.handleRegister);
		app.get("/employee/", eCon.handleGetAll);
		app.delete("/employee/delete", eCon.handleDelete);
		app.get("/employeeid", eCon.handleGetEmployeeById);
		app.post("/employee/login", eCon.handleLogin);
		
		
		// Admin API endpoints
		app.post("/admin/register/", adCon.handleRegisterAdmin);
		app.get("/admin/", adCon.handleGetAll);
		app.delete("/admin/delete/", adCon.handleDelete);
		app.get("/adminbyid", adCon.handleGetAdminById);
		
		
		
		
		app.start(8000);
		
		
				
	}

}
