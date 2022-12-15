package com.hcl.service;

import java.util.List;

import com.hcl.beans.User;
import com.hcl.repository.IUserDao;

public class UserServiceImp implements IUserService {

	private IUserDao dao;

	@Override
	public int addUser(User user) {

		return dao.addUser(user);
	}

	@Override
	public int updateUser(User user) {

		return dao.updateUser(user);
	}

	@Override
	public int deleteUserById(int userId) {

		return dao.deleteUserById(userId);
	}

	@Override
	public User selectUserById(int userId) {

		return dao.selectUserById(userId);
	}

	@Override
	public List<User> getAllUser() {

		return dao.getAllUser();
	}

}
