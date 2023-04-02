package com.cappack8.service;

import com.cappack8.model.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin);
	public int deleteAdmin(int adminId);
	public String getAdminName(int adminId);
	public String getAdminPassword(int adminId);
}