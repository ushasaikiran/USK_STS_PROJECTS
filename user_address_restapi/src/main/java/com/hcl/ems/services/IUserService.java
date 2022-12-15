package com.hcl.ems.services;

import org.springframework.http.ResponseEntity;

import com.hcl.ems.entities.User;

public interface IUserService {

	
	
	public ResponseEntity<String> registerUser(User user);
	
	
	public User getUserByUserName(String userName);
	
	
	
}
