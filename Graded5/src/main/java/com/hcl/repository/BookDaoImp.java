package com.hcl.repository;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hcl.beans.Book;

@Repository
public class BookDaoImp implements IBookDao {

	Connection conn = DBFactory.getDBConnection();
	PreparedStatement pstmt;

	@Override
	public int addBook(Book book) {
		String insertQuery = "insert into books(bookId,bookName,bookGenre,price) values(?,?,?,?)";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getBookGenre());
			pstmt.setDouble(4, book.getPrice());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateBook(Book book) {
		String updateQuery = "update books set bookName = ? , price = ? , bookGenre = ? where bookId =?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, book.getBookName());
			pstmt.setDouble(2, book.getPrice());
			pstmt.setString(3, book.getBookGenre());
			pstmt.setInt(4, book.getBookId());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteBookById(int bookId) {
		String deleteQuery = "delete from books where bookId = ?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, bookId);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int selectBookById(int bookId) {
		String selectOne = "select * from books where bookId = ?";
		Book book = new Book();
		try {
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setInt(1, bookId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int bookId1 = rs.getInt("bookId");
				String bookName = rs.getString("bookName");
				String bookGenre1 = rs.getString("bookGenre");
				double price = rs.getDouble("price");
				book.setBookId(bookId1);
				book.setBookName(bookName);
				book.setBookGenre(bookGenre1);
				book.setPrice(price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookId;

	}

	@Override
	public List<Book> selectAll() {
		List<Book> bookList = null;
		try {
			String selectAllQuery = "select * from books";
			pstmt = conn.prepareStatement(selectAllQuery);
			ResultSet rs = pstmt.executeQuery();
			bookList = new ArrayList<Book>();
			while (rs.next()) {
				int bookId = rs.getInt("bookId");
				String bookName = rs.getString("bookName");
				String bookGenre = rs.getString("bookGenre");
				double price = rs.getDouble("price");
				Book book = new Book();
				book.setBookId(bookId);
				book.setBookName(bookName);
				book.setBookGenre(bookGenre);
				book.setPrice(price);
				bookList.add(book);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return bookList;

	}

}
