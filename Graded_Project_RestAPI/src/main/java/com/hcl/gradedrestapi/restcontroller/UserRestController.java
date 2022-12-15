package com.hcl.gradedrestapi.restcontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.gradedrestapi.beans.User;
import com.hcl.gradedrestapi.services.IUserService;

@RestController
@RestControllerAdvice
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	IUserService service;
	
	@PostMapping("/adduser")
	public User addu(User user) {
		return service.addUser(user);
	}
	@PutMapping("/updateuser")
	public User updateu(User user) {
		return service.updateUser(user);
	}
	
	@GetMapping("/deleteuser/{userId}")
	public User deleteuById(@PathVariable int userId) {
		return service.deleteUserById(userId);
	}
	
	@GetMapping("/showallusers")
	public List<User> displayu(){
		return service.displayUser();
	}
	
	
}
