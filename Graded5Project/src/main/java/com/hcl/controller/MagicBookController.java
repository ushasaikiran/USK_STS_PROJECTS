package com.hcl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.beans.Book;
import com.hcl.service.IBookService;


@Controller
@RequestMapping("/books")
public class MagicBookController {

	
	@Autowired
	IBookService service;
	
	@RequestMapping(value="/hello", method =RequestMethod.GET)
	@ResponseBody
	public String sayHello() {
		return "HI USHA SAI KIRAN WELCOME TO THE BROWSER";
	}

	
	@RequestMapping("/index")
	public String indexPage() {
		
		return "index";
	}
	
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String addBook(Book book,HttpSession session) {
		
		
		int cnt = 	service.addBook(book);
		
		
		session.setAttribute("status", cnt);
		return "display";
	}
}
