package com.cappack8.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cappack8.model.Admin;
import com.cappack8.model.User;
import com.cappack8.repository.AdminRepository;
import com.cappack8.service.IAdminService;

@Service
public class AdminDao implements IAdminService{

	@Autowired
	AdminRepository arepos;
	@Override
	public Admin addAdmin(Admin admin) {
		return arepos.save(admin);
	}

	@Override
	public int deleteAdmin(int adminId) {
		if(arepos.existsById(adminId)) {
			arepos.deleteById(adminId);
			return 1;
		}
		else {
			return 0;
		}
		
	}

	@Override
	public String getAdminName(int adminId) {
		Admin admin = arepos.getById(adminId);
		User user = admin.getUser();
		String adminName = user.getUserName();
		return adminName;
	}

	@Override
	public String getAdminPassword(int adminId) {
		Admin admin = arepos.getById(adminId);
		User user = admin.getUser();
		String adminPassword = user.getUserPassword();
		return adminPassword;
	}

}