package com.hcl.surabi.restcontrollers;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.surabi.entities.Admin;
import com.hcl.surabi.entities.Menu;
import com.hcl.surabi.entities.MyOrderHistory;
import com.hcl.surabi.entities.User;
import com.hcl.surabi.services.AdminServiceImp;

@RestController
@RequestMapping("/admin") // BASE URL 

public class AdminRestController {// REST CONTROLLER CLASS

	
	// CREATING OBJECT FOR ADMINSERVICEIMP USING AUTOWIRED ANNOTATION
	@Autowired
	AdminServiceImp adminServiceImp;


	@PostMapping("/SIGN-IN") 
	public String registerAdmin(@RequestBody Admin admin) {
		adminServiceImp.saveAdmin(admin);
		return "!!!!ADMIN REGISTRATION SUCCESS!!!!";
	}

	
	@PostMapping("/ADMIN-LOGOUT")
	public String adminLogOut(@RequestBody Admin admin) {
		return adminServiceImp.logOutAdmin(admin);
	}

	@PostMapping("/ADD-USER")
	public String registerUser(@RequestBody User newuser) {
		adminServiceImp.saveUser(newuser);
		return "THANK YOU FOR YOUR REGISTRATION! YOU REGISTRATION IS SUCCESSFULL";
	}

	@GetMapping("/DISPLAY-ALL-THE-USERS")
	public List<User> displayAllTheUsers() {
		return adminServiceImp.displayAllUsers();
	}

	@DeleteMapping("/DELETE-THE-USER/{uid}")
	private String deleteTheUser(@PathVariable(value = "uid") Long id) {
		adminServiceImp.deleteUser(id);
		return "!!USER IS DELETED!!";
	}

	@PutMapping("/UPDATE-THE-USER/{userid}")
	private User update(@PathVariable(value = "userid") Long id, @RequestBody User user) {
		return adminServiceImp.update(id, user);

	}

	@GetMapping("/TODAY'SBILLS")
	public List<MyOrderHistory> ShowAllBillsGeneratedToday() {
		LocalDate ld = LocalDate.now();
		return adminServiceImp.showAllBillsToday(ld);
	}

	@GetMapping("/USER-BILL/{username}")
	public List<MyOrderHistory> userBills(@PathVariable(value = "username") String uname) {
		return adminServiceImp.userBill(uname);
	}

	@GetMapping("/MONTHLY-BILLS")
	public List<MyOrderHistory> ShowAllMonthlyBills() {
		return adminServiceImp.showAllBillsMonthly();
	}

	@GetMapping("/TOTAL-MONTHLY-BILL")
	public String totalMonthlyBills() {
		return adminServiceImp.totalMonthlyBill();
	}

	@PostMapping("/ADD-THE-ITEM")
	public String registerTheItem(@RequestBody Menu newitem) {
		adminServiceImp.saveItem(newitem);
		return "!!ITEM IS ADDED!!";
	}

	@GetMapping("/DISPLAY-ALL-THE-ITEMS")
	public List<Menu> ShowAllTheItems() {
		return adminServiceImp.showAllItems();
	}

	@DeleteMapping("/DELETE-THE-ITEM/{itemid}")
	private String deleteTheItem(@PathVariable(value = "itemid") Long id) {
		adminServiceImp.deleteItem(id);
		return "!!ITEM IS DELETED!!";
	}

	@PutMapping("/UPDATE-THE-ITEM/{itemid}")
	private Menu updateTheItem(@PathVariable(value = "itemid") Long id, @RequestBody Menu menu) {
		return adminServiceImp.update(id, menu);
	}

}