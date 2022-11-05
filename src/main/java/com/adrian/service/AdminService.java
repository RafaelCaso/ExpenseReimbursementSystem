package com.adrian.service;

import java.util.List;

import com.adrian.dao.AdminDao;
import com.adrian.exceptions.AdminDoesNotExistException;
import com.adrian.model.Admin;

public class AdminService {
	
	private AdminDao adminDao;
	
	public AdminService(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	public void registerAdmin(Admin a) {
		try {
			adminDao.getAdminByID(a.getId());
		} catch(AdminDoesNotExistException e) {
			adminDao.addAdmin(a);
		}
	}
	
	public List<Admin> getAllAdmins(){
		return adminDao.getAllAdmins();
	}
	
	public void deleteAdmin(Admin a) {
		try {
			adminDao.deleteAdmin(a.getId());
		} catch(AdminDoesNotExistException e) {
			e.printStackTrace();
			return;
		}
	}

}
