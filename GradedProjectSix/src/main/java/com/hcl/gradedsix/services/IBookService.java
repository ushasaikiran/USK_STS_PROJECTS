package com.hcl.gradedsix.services;

import com.hcl.gradedsix.beans.Book;

public interface IBookService {

    public Book addBook(Book book);
	
	public Book updateBook(Book book);
	
	public String deleteBookById(int bookId);
	
	public Book getBookById(int bookId);
	
	public Book getBookByBookName(Book bookName);
	
	public Book getBookByBookAuthor(Book bookAuthor);
	
	public Book getBookByBookPublication(Book bookPublication);
	
}
