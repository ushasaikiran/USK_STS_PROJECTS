package com.hcl.restapi.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Entity
@Table(name = "cm_table")
public class ContactManager {
	
	
	@Id
	@Column(name = "contact_manager_id")
	private int mid;
	
	@Column(name = "contact_manager_name")
	private String mname;
	
	@Column(name = "contact_manager_address")
	private String maddress;
	
	@Column(name = "contact_manager_salary")
	private double msalary;
	
	@Column(name = "contact_manager_number")
	private long number;
	
	

}
