package com.hcl.gradedsix.restcontroller;

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

import com.hcl.gradedsix.beans.User;
import com.hcl.gradedsix.services.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	IUserService service;
	

	 @PostMapping("/register")
		public ResponseEntity<String> register(@RequestBody User user){
			
			return service.registerUser(user);
			
		}
		
		@GetMapping("/login/{userName}/{userPassword}")
		public ResponseEntity<String> login(@PathVariable String userName,@PathVariable String userPassword,HttpSession session) {
			
			User user =  service.getUserByUserName(userName);
			
		
			
			ResponseEntity<String> response = null;
			
			if(user.getUserName().equals(userName)&& user.getUserPassword().equals(userPassword)){
				
				session.setAttribute("userName", userName);
				session.setAttribute("userPassword", userPassword);
				
				
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
