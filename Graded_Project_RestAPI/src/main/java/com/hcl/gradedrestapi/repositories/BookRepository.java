package com.hcl.gradedrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hcl.gradedrestapi.beans.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
