package com.hcl.ems.restcontrollers;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ems.entities.User;
import com.hcl.ems.services.IUserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserRestController {
 
	@Autowired
	IUserService service;
	
	
	
	
    @PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		
		return service.registerUser(user);
		
	}
	
	@GetMapping("/login/{userName}")
	public ResponseEntity<String> login(@PathVariable String userName,HttpSession session) {
		
		User user =  service.getUserByUserName(userName);
	
		
		ResponseEntity<String> response = null;
		
		if(user.getUserName().equals(userName)) {
			
			session.setAttribute("userName", userName);
			
			
			response = new ResponseEntity<String>("Login Success!",HttpStatus.OK);
		}
		else {
			
			response = new ResponseEntity<String>("Login Failed!", HttpStatus.BAD_REQUEST);
		}
		return response;
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		String msg = "Still Login";
		
		
		if(session.getAttribute("userName")==null){
			
			msg = "Logout Success";
			
		}
		return msg;
		
		
		
	}
	

	
	
}
