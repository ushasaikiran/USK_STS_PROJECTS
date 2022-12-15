package com.hcl.gradedsix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.gradedsix.beans.User;
import com.hcl.gradedsix.repositories.UserRepository;
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
		return repo.findUserByUserName(userName);
	}

}
