package com.hcl.gradedsix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.gradedsix.beans.Book;
import com.hcl.gradedsix.repositories.BookRepository;

@Service
public class BookServiceImp implements IBookService {

	@Autowired
	BookRepository repo;
	
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return repo.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return repo.save(book);
	}

	@Override
	public String deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		repo.deleteById(bookId);
		
		return "book deleted ";
	}

	@Override
	public Book getBookById(int bookId) {
		// TODO Auto-generated method stub
		return repo.findById(bookId).orElse(null);
	}

	@Override
	public Book getBookByBookName(Book bookName) {
		// TODO Auto-generated method stub
		return repo.findBookByBookName(bookName);
	}

	@Override
	public Book getBookByBookAuthor(Book bookAuthor) {
		// TODO Auto-generated method stub
		return repo.findBookByBookAuthor(bookAuthor);
	}

	@Override
	public Book getBookByBookPublication(Book bookPublication) {
		// TODO Auto-generated method stub
		return repo.findBookByBookPublication(bookPublication);
	}

}
