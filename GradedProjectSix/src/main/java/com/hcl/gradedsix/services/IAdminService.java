package com.hcl.gradedsix.services;

import org.springframework.http.ResponseEntity;

import com.hcl.gradedsix.beans.Admin;





public interface IAdminService {
	
	public ResponseEntity<String> registerAdmin(Admin admin);
	
	public Admin getAdminByAdminName(String adminName);

}
