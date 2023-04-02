package com.cappack8.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cappack8.dao.AdminDao;
import com.cappack8.model.Admin;

@RestController
public class AdminController {

	@Autowired
	AdminDao adao;
	
	
	@PostMapping(path="/createAdmin")
	public Admin createAdmin(@RequestBody Admin admin)
	{
		return adao.addAdmin(admin);
	}
	@GetMapping(path="/deleteAdminById/{adminId}")
	public int deleteAdminById(@PathVariable Integer adminId) {
		return adao.deleteAdmin(adminId);
	}
	@GetMapping(path="/getAdminNameById/{adminId}")
	public String getAdminNameById(@PathVariable Integer adminId) {
		return adao.getAdminName(adminId);
	}
	@GetMapping(path="/getAdminPasswordById/{adminId}")
	public String getAdminPasswordById(@PathVariable Integer adminId) {
		return adao.getAdminPassword(adminId);
	}
}