package com.hcl.gradedsix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.gradedsix.beans.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	
	
	public Admin findAdminByAdminName(String adminName);
}
