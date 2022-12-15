package com.hcl.gradedproject.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.gradedproject.entity.Book;
import com.hcl.gradedproject.entity.User;
import com.hcl.gradedproject.services.BookServicesImp;
import com.hcl.gradedproject.services.UserServiceImp;

@RequestMapping("/api/user")
@RestControllerAdvice
public class UserRestController 
{
	@Autowired
	UserServiceImp service;
	@Autowired
	BookServicesImp bookService2;
	
	@PostMapping("/userregister")
	public ResponseEntity<String> register(@RequestBody User user)
	{
		return service.registerUser(user);
	}
	@GetMapping("/userlogin/{userName}/{userPassword}")
	public ResponseEntity<String> login(@PathVariable String userName,@PathVariable String userPassword,HttpSession session) 
	{
		
		User user =  service.getUserByUserName(userName);
		ResponseEntity<String> response = null;
		if(user.getUserName().equals(userName)&& (user.getUserPassword().equals(userPassword))) {
			session.setAttribute("userName", userName);
			response = new ResponseEntity<String>("User Login Success!",HttpStatus.OK);
		}
		else 
		{
			response = new ResponseEntity<String>("User Login Failed!", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	@GetMapping("/userlogout")
	public String logout(HttpSession session)
	{
		String msg = "Still Login";
		if(session.getAttribute("userName")==null)
		{
			msg = "User Logout Success";
		}
		return msg;
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks()
	{
		return bookService2.getAllBooks();
	}
	
	@GetMapping("/getBookByAuthorName/{authorName}")
	public List<Book> getBookByAuthorName(@PathVariable String authorName)
	{
		return bookService2.getBookByAuthorName(authorName);
	}
	
	@GetMapping("/getBookByBookName/{bookName}")
	public Book getBookByBookName(@PathVariable String bookName)
	{
		return bookService2.getBookByBookName(bookName);
	}
	@GetMapping("/getBookByPublicationName/{publicationName}")
	public Book getBookByPublicationName(@PathVariable String publicationName)
	{
		return bookService2.getBookByPublicationName(publicationName);
	}
	
	@GetMapping("/getBookById/{bookId}")
	public Book getBookById(@PathVariable int bookId)
	{
		return bookService2.getBookById(bookId);
	}
	
	@GetMapping("/getbyrange/{start}/{end}")
	public List<Book> getBookByPriceRange(int start, int end)
	{
		return bookService2.getBookByPriceRange(start, end);
	}
	@GetMapping("/getBooksSortedByPrice")
	public List<Book> getAllSorted()
	{
		return bookService2.getAllSorted();
	}
}
