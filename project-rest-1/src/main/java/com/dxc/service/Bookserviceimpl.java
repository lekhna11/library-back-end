package com.dxc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.model.Book;
import com.dxc.repository.Bookrepo;

@Service
public class Bookserviceimpl implements Bookservice {
	
	@Autowired
	public Bookrepo bookRepo;

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookRepo.save(book);
	}

	@Override
	public Book update(Book book) {
		// TODO Auto-generated method stub
		Book books = bookRepo.save(book);
		return books;
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public void deleteBybookId(int bookId) {
		// TODO Auto-generated method stub
		Book book = bookRepo.findBybookId(bookId);
		bookRepo.delete(book);

	}

	@Override
	public Book findBybookId(int bookId) {
		// TODO Auto-generated method stub
		Book book = bookRepo.findBybookId(bookId);
		return bookRepo.findBybookId(bookId);
	}

}