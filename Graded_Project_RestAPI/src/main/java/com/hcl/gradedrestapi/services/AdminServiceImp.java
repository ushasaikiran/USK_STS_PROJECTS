package com.hcl.gradedrestapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.gradedrestapi.beans.Admin;
import com.hcl.gradedrestapi.repositories.AdminRepository;





@Service
public class AdminServiceImp implements IAdminService {

	@Autowired
	AdminRepository repo;

	@Override
	public ResponseEntity<String> registerAdmin(Admin admin) {
	ResponseEntity<String> response = null;
		
		Admin u =  repo.save(admin);
		
		if(u!=null) {
			response = new ResponseEntity<String>("Admin Registration Success",HttpStatus.ACCEPTED);
			
		}else {
			
			response = new ResponseEntity<String>("Admin Registration Failed!",HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
		
	}

	@Override
	public Admin getAdminByAdminName(String adminName) {
		
		return repo.findAdminByAdminName(adminName);
	}
	

}
