package com.hcl.ems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.ems.entities.User;
import com.hcl.ems.repositories.UserRepository;


@Service
public class UserServiceImp implements IUserService {

	@Autowired
	UserRepository repo;
	
	@Override
	public ResponseEntity<String> registerUser(User user) {

		ResponseEntity<String> response = null;
		
		User u =  repo.save(user);
		
		if(u!=null) {
			response = new ResponseEntity<String>("User Registration Success",HttpStatus.ACCEPTED);
			
		}else {
			
			response = new ResponseEntity<String>("User Registration Failed!",HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
		
	}

	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return repo.findByUserName(userName);
	}

}
