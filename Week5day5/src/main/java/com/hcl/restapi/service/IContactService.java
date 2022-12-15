package com.hcl.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.restapi.entity.ContactManager;

@Service
public interface IContactService {

	public ContactManager addManager(ContactManager contactmanager);

	public ContactManager updateManager(ContactManager contactmanager);

	public ContactManager getManagerById(int mid);

	public String deleteManagerById(int mid);

	public List<ContactManager> getAllManagers();

	public ContactManager getManagerByName(String mname);

	public List<ContactManager> getManagerBySalary(double msalary);

	public List<ContactManager> getManagerBySalaryRange(double low, double high);

	public ContactManager deleteManagerByName(String mname);

	public List<ContactManager> getAllSorted();

}
