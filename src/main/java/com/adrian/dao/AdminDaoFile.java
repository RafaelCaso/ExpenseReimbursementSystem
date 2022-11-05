package com.adrian.dao;

import java.util.ArrayList;
import java.util.List;

import com.adrian.exceptions.AdminDoesNotExistException;
import com.adrian.model.Admin;

public class AdminDaoFile implements AdminDao {
	
	private FileIO<List<Admin>> io;
	
	public AdminDaoFile() {
		this.io = new FileIO<List<Admin>>("admins.txt");
	}

	@Override
	public void addAdmin(Admin a) {
		List<Admin> aList = io.readObject();
		if(aList == null) {
			aList = new ArrayList<>();
		}
		
		aList.add(a);
		io.writeObject(aList);
	}

	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> aList = io.readObject();
		
		if(aList == null) {
			aList = new ArrayList<>();
		}
		return aList;
	}

	@Override
	public Admin getAdminByID(int id) {
		List<Admin> aList = io.readObject();
		
		if(aList == null) {
			aList = new ArrayList<>();
		}
		
		for(Admin a : aList) {
			if(a.getId() == id) {
				return a;
			}
		}
		throw new AdminDoesNotExistException();
	}

	@Override
	public void deleteAdmin(int id) {
		List<Admin> aList = io.readObject();
		if(aList == null) {
			aList = new ArrayList<>();
		}
		
		for(int i = 0; i < aList.size(); i++) {
			if(aList.get(i).getId() == id) {
				aList.remove(i);
				return;
			}
		}
		
		throw new AdminDoesNotExistException();
	}

	@Override
	public void updateAdmin(Admin a) {
		List<Admin> aList = io.readObject();
		if(aList == null) {
			aList = new ArrayList<>();
		}
		
		for(int i = 0; i < aList.size(); i++) {
			if(aList.get(i).getId() == a.getId()) {
				aList.remove(i);
				aList.add(a);
			}
		}
		
		throw new AdminDoesNotExistException();
	}

}
