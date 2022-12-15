package com.hcl.gradedrestapi.beans;

import javax.persistence.Entity;



import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="usertable")
public class User {
	
	
	
	@Id
	private int userId;
	
	private String userName;
	
	private String Password;
	
	
	public User() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
}
