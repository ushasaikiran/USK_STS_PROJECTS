package com.hcl.service;

import java.util.List;

import com.hcl.beans.User;

public interface IUserService {
	
public int addUser(User user);
	
	public int updateUser(User user);

	public int deleteUserById(int userId);

	public User selectUserById(int userId);
	
	public List<User> getAllUser();


}
