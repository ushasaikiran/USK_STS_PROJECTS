package com.hcl.surabi.entities;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="admin")
public class Admin {
    

    @Id // @ Id ANNOTATION IS USED TO MAKE IT AS PRIMARY KEY(NOT TO ALLOW DUPLICATES)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // HERE ID IS AUTO GENERATED
    private long adminId;
    private String adminuserName;
    private String adminpassword;


    // SETTER AND GETTER METHODS FOR ABOVE INSTANCE VARIABLES
    public long getAdminId() {
        return adminId;
    }
    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }
    public String getAdminuserName() {
        return adminuserName;
    }
    public void setAdminuserName(String adminuserName) {
        this.adminuserName = adminuserName;
    }
    public String getAdminpassword() {
        return adminpassword;
    }
    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }



}