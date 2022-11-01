package com.adrian.dao;

import java.util.List;

import com.adrian.model.Admin;

public interface AdminDao {
	
	public void addAdmin(Admin a);
	public List<Admin> getAllAdmins();
	public Admin getAdminByID(int id);
	public void deleteAdmin(int id);
	public void updateAdmin(Admin a);
	

}
