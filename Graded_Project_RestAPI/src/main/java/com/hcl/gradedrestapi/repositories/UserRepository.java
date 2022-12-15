package com.hcl.gradedrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.gradedrestapi.beans.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
