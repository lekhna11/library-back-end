package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.Book;

public interface Bookrepo extends JpaRepository<Book, Integer> {
	
	public Book findBybookId(Integer bookId);


}