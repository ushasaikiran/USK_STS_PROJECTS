package com.hcl.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ems.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	
	public User findByUserName(String userName);
	
}
