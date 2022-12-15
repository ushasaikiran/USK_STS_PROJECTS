package com.hcl.gradedrestapi.services;

import java.util.List;

import com.hcl.gradedrestapi.beans.User;

public interface IUserService {
	
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	
	public User deleteUserById(int userId);
	
	public List<User> displayUser();
	
	

}
