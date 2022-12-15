package com.hcl.gradedrestapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.gradedrestapi.beans.User;
import com.hcl.gradedrestapi.repositories.UserRepository;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	UserRepository repo;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public User deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return repo.findById(userId).orElse(null);
	}

	@Override
	public List<User> displayUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
