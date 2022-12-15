package com.hcl.gradedproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.gradedproject.entity.Admin;
import com.hcl.gradedproject.repositories.AdminRepository;

@Service
public class AdminServiceImp
{
	@Autowired
	AdminRepository adminRepo;
	

	public ResponseEntity<String> registerAdmin(Admin admin) {

		ResponseEntity<String> response = null;
		
		Admin a =  adminRepo.save(admin);
		
		if(a!=null) {
			response = new ResponseEntity<String>("Admin Registration Success",HttpStatus.ACCEPTED);
			
		}else {
			
			response = new ResponseEntity<String>("Admin Registration Failed!",HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
		
	}

	
	public Admin getAdminByAdminName(String adminName)
	{
		return adminRepo.findByAdminName(adminName);
	}

	
}
