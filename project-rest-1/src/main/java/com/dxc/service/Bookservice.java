package com.dxc.service;

import java.util.List;

import com.dxc.model.Book;

public interface Bookservice {
	
	public Book save(Book book);
	
	public Book update(Book book);
	
	List<Book> getBooks();

	public void deleteBybookId(int bookId);

	public Book findBybookId(int bookId);

}