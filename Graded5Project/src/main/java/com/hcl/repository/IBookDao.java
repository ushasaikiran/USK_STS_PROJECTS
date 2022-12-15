package com.hcl.repository;

import java.util.List;

import com.hcl.beans.Book;

public interface IBookDao {

	public int addBook(Book book);

	public int updateBook(Book book);

	public int deleteBookById(int bookId);

	public int selectBookById(int bookId);

	public List<Book> selectAll();

}
