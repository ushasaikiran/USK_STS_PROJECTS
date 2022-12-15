package com.hcl.hibernatemappings.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_table")
public class Address {

	@Id
	private long addressId;
	private int flatNo;
	private String area;
	private String city;
	private long zipcode;
	
}
