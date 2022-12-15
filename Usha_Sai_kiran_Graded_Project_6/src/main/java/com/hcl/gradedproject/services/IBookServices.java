package com.hcl.gradedproject.services;

import java.util.List;

import com.hcl.gradedproject.entity.Book;


public interface IBookServices 
{
	public Book addBook(Book book);
	public Book updateBook(Book book);
	public String deleteBookById(int bookId);
	public List<Book> getAllBooks();
	public Book getBookById(int bookId);
	public List<Book> getBookByAuthorName(String authorName);
	public Book getBookByBookName(String bookName);
	public Book getBookByPublicationName(String publicationName);
	public List<Book> getBookByPriceRange(int start,int end);
	public List<Book>  getAllSorted();
}
