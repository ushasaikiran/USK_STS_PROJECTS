package com.hcl.surabi.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data 
@Entity
@Table(name="user")
public class User {
	
    @Id // @ Id ANNOTATION IS USED TO MAKE IT AS PRIMARY KEY(NOT TO ALLOW DUPLICATES)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // HERE ID IS AUTO GENERATED
    private long userId;
    
    
    private String userName;
    private String password;
    private String user_Address;
    private int user_age;
    
    
    // SETTER AND GETTER METHODS FOR ABOVE INSTANCE VARIABLES
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser_Address() {
        return user_Address;
    }
    public void setUser_Address(String user_Address) {
        this.user_Address = user_Address;
    }
    public int getUser_age() {
        return user_age;
    }
    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }
    
}