package com.hcl.gradedproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.gradedproject.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> 
{
	//public List<Book> getBookByAuthorName(String authorName);

		public List<Book> findByAuthorName(String authorName);
		public Book findBookByBookName(String bookName);
		public Book findBookByPublicationName(String publicationName);
		
		@Query("select b from Book b where price between ?1 and ?2 order by price asc")
		public List<Book> findBookByPriceRange(int start,int end);
		
		




}
