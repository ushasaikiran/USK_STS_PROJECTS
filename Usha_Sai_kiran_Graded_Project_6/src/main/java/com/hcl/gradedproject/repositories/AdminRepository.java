package com.hcl.gradedproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.gradedproject.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>
{

	public Admin findByAdminName(String adminName);
	
}
