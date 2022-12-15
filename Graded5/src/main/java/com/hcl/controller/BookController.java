package com.hcl.controller;

import java.util.List;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.beans.Book;
import com.hcl.service.IBookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	
	@Autowired
	IBookService service;
	
	
	
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	@ResponseBody
	public String sayHello() {
		return "HI USHA SAI KIRAN WELCOME TO THE BROWSER";
	}
	
	@RequestMapping("/index")
	public String indexPage() {
		
		return "index";
	}
	
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String addBook(Book book,HttpSession session) {
		
	int cnt = 	service.addBook(book);
		
	//	System.out.println(product);
		
		session.setAttribute("status", cnt);
		return "display";
		
	}
	
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateBook(Book book,HttpSession session) {
		
	int cnt = 	service.updateBook(book);
		
	//	System.out.println(product);
		
		session.setAttribute("status", cnt);
		return "display";
		
	}
	
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String deleteBook(@RequestParam int bookId,HttpSession session) {
		
	int cnt = 	service.deleteBookById(bookId);
		
	//	System.out.println(product);
		
		session.setAttribute("status", cnt);
		return "display";
		
	}
	
	@RequestMapping("/getall")
	public String getAllProducts(HttpSession session) {
		
		
		List<Book> list = service.selectAll();
		
		session.setAttribute("list", list);
		return "showall";
	}
	
	
	
}
