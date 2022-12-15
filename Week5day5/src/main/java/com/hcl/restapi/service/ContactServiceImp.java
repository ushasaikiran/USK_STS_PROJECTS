package com.hcl.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.hcl.restapi.entity.ContactManager;
import com.hcl.restapi.repository.ContactManagerRepository;

public class ContactServiceImp implements IContactService {

	
	@Autowired
	ContactManagerRepository repo;
	
	
	@Override
	public ContactManager addManager(ContactManager contactmanager) {
		// TODO Auto-generated method stub
		return repo.save(contactmanager);
	}

	@Override
	public ContactManager updateManager(ContactManager contactmanager) {
		// TODO Auto-generated method stub
		return repo.save(contactmanager);
	}

	@Override
	public ContactManager getManagerById(int mid) {
		// TODO Auto-generated method stub
		return repo.findById(mid).orElse(null); 
	}

	@Override
	public String deleteManagerById(int mid) {
		// TODO Auto-generated method stub
		
		repo.deleteById(mid);
		return "!Manager Deleted!";
	}

	@Override
	public List<ContactManager> getAllManagers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public ContactManager getManagerByName(String mname) {
		// TODO Auto-generated method stub
		return repo.findByMname(mname);
	}

	@Override
	public List<ContactManager> getManagerBySalary(double msalary) {
		// TODO Auto-generated method stub
		return repo.findByMsalary(msalary);
	}

	@Override
	public List<ContactManager> getManagerBySalaryRange(double low, double high) {
		// TODO Auto-generated method stub
		return repo.findBySalaryRange(low, high);
	}

	@Override
	public ContactManager deleteManagerByName(String mname) {
		// TODO Auto-generated method stub
		return repo.deleteByMname(mname);
	}

	@Override
	public List<ContactManager> getAllSorted() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by("msalary"));
	}

	

}
