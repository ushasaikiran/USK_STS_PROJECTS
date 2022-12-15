package com.hcl.gradedsix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hcl.gradedsix.beans.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	public User findUserByUserName(String userName);
}
