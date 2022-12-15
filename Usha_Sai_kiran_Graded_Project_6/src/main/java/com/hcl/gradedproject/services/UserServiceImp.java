package com.hcl.gradedproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.gradedproject.entity.Book;
import com.hcl.gradedproject.entity.User;
import com.hcl.gradedproject.repositories.BookRepository;
import com.hcl.gradedproject.repositories.UserRepository;

@Service
public class UserServiceImp
{
	@Autowired
	UserRepository repo;
	BookRepository bookRepo;
	
	public ResponseEntity<String> registerUser(User user) {
		ResponseEntity<String> response = null;
		User u =  repo.save(user);
		if(u!=null) {
			response = new ResponseEntity<String>("User Registration Success",HttpStatus.ACCEPTED);
			
		}else
		{
			response = new ResponseEntity<String>("User Registration Failed!",HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}

	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return repo.findByUserName(userName);
	}
	
	
}
