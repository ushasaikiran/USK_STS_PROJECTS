package com.hcl.beans;

import javax.persistence.Entity;

@Entity
public class Book {

	private int bookId;
	private String bookName;
	private String bookGenre;
	private double price;

	public Book(int bookId, String bookName, String bookGenre, double price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookGenre = bookGenre;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookGenre=" + bookGenre + ", price=" + price
				+ "]";
	}

	public Book() {

	}

}
