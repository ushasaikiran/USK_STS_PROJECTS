package com.hcl.surabi.services;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.surabi.entities.Menu;
import com.hcl.surabi.entities.MyOrderHistory;
import com.hcl.surabi.entities.User;
import com.hcl.surabi.repositories.ItemsMenuRepository;
import com.hcl.surabi.repositories.OrderHistoryRepository;
import com.hcl.surabi.repositories.UserRepository;

@Service
//IMPLEMENTATION CLASS WHICH IMPLEMENTS THE IUSER SERVICE INTERFACE
public class UserServiceImp implements IUserService{

	// CREATING OBJECT FOR USER REPOSITORY USING AUTOWIRED ANNOTATION
	@Autowired
	UserRepository userRepository;

	// CREATING OBJECT FOR MENU REPOSITORY USING AUTOWIRED ANNOTATION
	@Autowired
	ItemsMenuRepository itemsMenuRepository;

	// CREATING OBJECT FOR ORDERHISTORY REPOSITORY USING AUTOWIRED ANNOTATION
	@Autowired
	OrderHistoryRepository OrderHistoryRepository;

	// CREATING MENU LIST AS ARRAY
	List<Menu> stores = new ArrayList<Menu>();

	// CURRENT DATE IS CALLED USING "lD"
	LocalDate ld = LocalDate.now();

	public User saveUser(User newuser) {

		return userRepository.save(newuser);

	}

	// TO LOGIN AS A USER
	public String loginUser(User user) {

		if (userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()) != null) {

			System.out.println("Username is " + user.getUserName());
			return "User sucessfully logged in";
		} else {

			return "User not found";

		}
	}

	// METHOD TO LOGOUT AS A USER
	public String logoutUser(User user) {

		if (userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()) != null) {
			return "User sucessfully log out";
		} else {

			return "Incorrect user details";

		}
	}

	// METHOD TO DISPLAY ALL ITEMS
	public List<Menu> showAll() {
		return itemsMenuRepository.findAll();
	}

	// COLLECTING THE ITEMS AND TO ORDER THEM GIVEN BY THE USER
	public String searchItem(MyOrderHistory order_history) {
		int sum = 0;
		Menu menu = itemsMenuRepository.findByItemName(order_history.getItemName());

		MyOrderHistory history = new MyOrderHistory();
		int price = menu.getPrice();
		sum = price * order_history.getPlates();
		history.setItemName(order_history.getItemName());
		history.setTotal_amt(sum);
		history.setUserName(order_history.getUserName());
		history.setPlates(order_history.getPlates());
		history.setDate(ld);

		OrderHistoryRepository.save(history);
		return "TOTAL AMOUNT IS: " + sum;
	}

	// USER ORDER HISTORY
	public List<MyOrderHistory> userOrders(String userName) {
		return OrderHistoryRepository.findByUserName(userName);
	}

	// ADDING THE ITEMS TO THE STORE
	public List<Menu> addToStore(String itemname) {

		Menu store = itemsMenuRepository.findByItemName(itemname);

		stores.add(store);

		return stores;
	}

	// FINAL BILL FOR THE USER TO PAY
	public String finalBill(String uname) {

		List<MyOrderHistory> history = OrderHistoryRepository.findByUserName(uname);
		LocalDate ld = LocalDate.now();
		int sum = 0;
		for (MyOrderHistory order : history) {
			if (ld.equals(order.getDate())) {
				sum = sum + order.getTotal_amt();
			}
		}
		return "THE FINAL BILL IS: " + sum;
	}

}