package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Book;
import com.dxc.service.Bookservice;

@RestController
public class Bookcontroller {
	
	@Autowired
	public Bookservice bookService;
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("books")
	public List<Book> getBook()
	{
		return bookService.getBooks();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping(path = "book/{bookId}")
	public void delete(@PathVariable("bookId") int bookId)
	{
		bookService.deleteBybookId(bookId);
	
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("book")
	public Book save(@RequestBody Book book)
	{
		return bookService.save(book);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("book")
	public Book update(@RequestBody Book book)
	{
		return bookService.update(book);
	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path = "book/{bookId}")
	public Book getBook(@PathVariable("bookId") int bookId) {
		Book book = bookService.findBybookId(bookId);
		return book;
	}
}