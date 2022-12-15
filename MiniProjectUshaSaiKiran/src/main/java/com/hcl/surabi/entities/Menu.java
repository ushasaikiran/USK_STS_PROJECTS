package com.hcl.surabi.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "menu")
public class Menu {
	
	
	
	@Id // @ Id ANNOTATION IS USED TO MAKE IT AS PRIMARY KEY(NOT TO ALLOW DUPLICATES)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // HERE ID IS AUTO GENERATED
	private long Itemid;
	private String itemName;
	private int price;

	// SETTER AND GETTER METHODS FOR ABOVE INSTANCE VARIABLES
	public long getItemid() {
		return Itemid;
	}

	public void setItemid(long itemid) {
		Itemid = itemid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}