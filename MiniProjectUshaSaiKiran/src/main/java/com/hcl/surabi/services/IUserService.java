package com.hcl.surabi.services;

import java.util.List;

import com.hcl.surabi.entities.Menu;
import com.hcl.surabi.entities.MyOrderHistory;
import com.hcl.surabi.entities.User;


//USER INTERFACE
public interface IUserService {

	public User saveUser(User newuser);

	public String loginUser(User user);// LOGIN AS USER

	public String logoutUser(User user); //lOGOUT

	public List<Menu> showAll();// DISPLAY ALL ITEMS FOR THE USER

	public String searchItem(MyOrderHistory order_history); // ORDER HISTORY

	public List<MyOrderHistory> userOrders(String userName); //USERS ORDER

	public List<Menu> addToStore(String itemname);// ADDING ITEMS TO THE STORE

	public String finalBill(String uname);// FINAL BILL

}
