package com.hcl.surabi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.surabi.entities.User;
@Repository


public interface UserRepository extends JpaRepository<User, Long> {


	// USER DEFINED METHOD TO FIND USER BY NAME AND PASSWORD
	public User findByUserNameAndPassword(String username,String password);
}
