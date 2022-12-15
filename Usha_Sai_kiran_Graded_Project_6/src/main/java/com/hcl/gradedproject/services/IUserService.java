package com.hcl.gradedproject.services;

import org.springframework.http.ResponseEntity;

import com.hcl.gradedproject.entity.User;


public interface IUserService 
{
	public ResponseEntity<String> registerUser(User user);
	public User getUserByUserName(String userName);
	
	
}
