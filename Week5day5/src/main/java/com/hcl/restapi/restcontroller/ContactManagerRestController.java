package com.hcl.restapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hcl.restapi.entity.ContactManager;
import com.hcl.restapi.service.IContactService;

@RequestMapping("/api/contactmanagers")
public class ContactManagerRestController {
	@Autowired
	IContactService service;

	@PostMapping("/add")
	public ContactManager add(@RequestBody ContactManager contactmanager) {
		return service.addManager(contactmanager);

	}

	@PutMapping("/update")
	public ContactManager update(@RequestBody ContactManager contactmanager) {

		return service.updateManager(contactmanager);
	}

	@GetMapping("/get/{mid}")
	public ContactManager getById(@PathVariable int mid) {

		return service.getManagerById(mid);
	}

	@DeleteMapping("/delete/{mid}")
	public String deleteById(@PathVariable int mid) {

		return service.deleteManagerById(mid);
	}

	@GetMapping("/getall")
	public List<ContactManager> getAll() {

		return service.getAllManagers();
	}
	
	@GetMapping("/getbyname/{mname}")
	public ContactManager getByName(@PathVariable String mname) {
		
		return service.getManagerByName(mname);
	}
	
	@GetMapping("/getbysalary/{msalary}")
	public List<ContactManager> getBySalary(@PathVariable double msalary){
		
		return service.getManagerBySalary(msalary);
	}
	
	@GetMapping("/getbyrange/{low}/{high}")
	public List<ContactManager> getBySalaryRange(@PathVariable double low,@PathVariable double high){

		return service.getManagerBySalaryRange(low, high);
	}
	
	@DeleteMapping("/deletebyname/{mname}")
	public ContactManager deleteByName(@PathVariable String mname) {
		
		return service.getManagerByName(mname);
	}
	
	@GetMapping("/getallsorted")
	public List<ContactManager> getAllSorted(){
		
		return service.getAllSorted();
	}
}
