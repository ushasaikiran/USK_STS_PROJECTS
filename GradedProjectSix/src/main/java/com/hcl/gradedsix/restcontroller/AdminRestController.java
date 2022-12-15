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

import com.hcl.gradedsix.beans.Admin;
import com.hcl.gradedsix.services.IAdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

	@Autowired
    IAdminService service;
	
	
	
	 @PostMapping("/register")
		public ResponseEntity<String> register(@RequestBody Admin admin){
			
			return service.registerAdmin(admin);
			
		}
		
		@GetMapping("/login/{adminName}/{adminPassword}")
		public ResponseEntity<String> login(@PathVariable String adminName,@PathVariable String adminPassword,HttpSession session) {
			
			Admin admin =  service.getAdminByAdminName(adminName);
		
			
			ResponseEntity<String> response = null;
			
			if(admin.getAdminName()!=null &&admin.getAdminName().equals(adminName)&& admin.getAdminPassword().equals(adminPassword)){
				
				session.setAttribute("adminName", adminName);
				session.setAttribute("adminPassword", adminPassword);
				
				
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
			
			
			if(session.getAttribute("adminName")==null){
				
				msg = "Logout Success";
				
			}
			return msg;
			
			
			
		}
}
