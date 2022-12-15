package com.hcl.gradedrestapi.restcontroller;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.gradedrestapi.beans.Book;
import com.hcl.gradedrestapi.services.IBookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController

@RequestMapping("api/books")
public class BookRestController {

	@Autowired
	IBookService service;
	
	
	@PostMapping("/addbook")
	public Book add(@RequestBody Book book) {
		return service.addBook(book);
	}
	@PutMapping("/updatebook")
	public Book update(@RequestBody Book book) {	
		return service.updateBook(book);
	}
	
	@GetMapping("/deletebook/{bookId}")
	public Book deleteById(@PathVariable int bookId) {
		return  service.deleteBookById(bookId);
	}
	@GetMapping("/getallbooks")
	public List<Book> display(){
		return service.displayBook();
	}
	
}
