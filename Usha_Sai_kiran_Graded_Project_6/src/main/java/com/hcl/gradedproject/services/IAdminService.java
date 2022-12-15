package com.hcl.gradedproject.services;

import org.springframework.http.ResponseEntity;

import com.hcl.gradedproject.entity.Admin;

public interface IAdminService 
{
	public ResponseEntity<String> registerAdmin(Admin admin);
	public Admin getAdminByAdminName(String adminName);
	
}
