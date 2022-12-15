package com.hcl.gradedrestapi.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.gradedrestapi.beans.Book;
import com.hcl.gradedrestapi.repositories.BookRepository;

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
	public Book deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		return repo.findById(bookId).orElse(null);
	}

	@Override
	public List<Book> displayBook() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	


}
