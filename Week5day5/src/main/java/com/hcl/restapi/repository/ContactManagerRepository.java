package com.hcl.restapi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.restapi.entity.ContactManager;

@Repository
public interface ContactManagerRepository extends JpaRepository<ContactManager, Integer> {

	ContactManager findByMname(String mname);
	
	List<ContactManager> findByMsalary(double msalary);
	
	@Query("select m from ContactManager m where m.msalary between ?1 and ?2 order by m.mname asc ")
	List<ContactManager> findBySalaryRange(double low,double high);
	
	
	ContactManager deleteByMname(String mname);
	
}
