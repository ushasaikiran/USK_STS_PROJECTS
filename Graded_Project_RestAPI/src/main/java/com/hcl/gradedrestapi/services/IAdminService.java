package com.hcl.gradedrestapi.services;

import org.springframework.http.ResponseEntity;

import com.hcl.gradedrestapi.beans.Admin;





public interface IAdminService {
	
	public ResponseEntity<String> registerAdmin(Admin admin);
	
	public Admin getAdminByAdminName(String adminName);

}
