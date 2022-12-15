package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.beans.Book;

import com.hcl.repository.IBookDao;

@Service
public class BookServiceImp implements IBookService {

	@Autowired
	IBookDao dao;

	public BookServiceImp() {

		
	}

	@Override
	public int addBook(Book book) {

		return dao.addBook(book);
	}

	@Override
	public int updateBook(Book book) {
		return dao.updateBook(book);
	}

	@Override
	public int deleteBookById(int bookId) {
		return dao.deleteBookById(bookId);

	}

	@Override
	public int selectBookById(int bookId) {
		return dao.selectBookById(bookId);

	}

	@Override
	public List<Book> selectAll() {
		return dao.selectAll();
	}

}