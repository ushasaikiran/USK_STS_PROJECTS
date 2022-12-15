package com.hcl.gradedrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.gradedrestapi.beans.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	
	
	public Admin findAdminByAdminName(String adminName);
}
