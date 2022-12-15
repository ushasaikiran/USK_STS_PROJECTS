package com.hcl.gradedsix.services;

import org.springframework.http.ResponseEntity;

import com.hcl.gradedsix.beans.User;

public interface IUserService {

	
	
public ResponseEntity<String> registerUser(User user);
	
	public User getUserByUserName(String userName);

}
