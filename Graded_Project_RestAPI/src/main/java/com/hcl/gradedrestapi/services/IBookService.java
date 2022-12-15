package com.hcl.gradedrestapi.services;

import java.util.List;

import com.hcl.gradedrestapi.beans.Book;

public interface IBookService {

	public Book addBook(Book book);
	
	public Book updateBook(Book book);
	
	
	public Book deleteBookById(int bookId);
	
	public List<Book> displayBook();
	
	
}
