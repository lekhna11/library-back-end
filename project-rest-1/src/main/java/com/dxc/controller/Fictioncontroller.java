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

import com.dxc.model.Fiction;
import com.dxc.service.Fictionservice;


@RestController
public class Fictioncontroller {
	
	@Autowired
	public Fictionservice fictionService;
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("fictions")
	public List<Fiction> getBook()
	{
		return fictionService.getBooks();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping(path = "fiction/{bookId}")
	public void delete(@PathVariable("bookId") int bookId)
	{
		fictionService.deleteBybookId(bookId);
	
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("fiction")
	public Fiction save(@RequestBody Fiction fiction)
	{
		return fictionService.save(fiction);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("fiction")
	public Fiction update(@RequestBody Fiction fiction)
	{
		return fictionService.update(fiction);
	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path = "fiction/{bookId}")
	public Fiction getFiction(@PathVariable("bookId") int bookId) {
		Fiction fiction = fictionService.findBybookId(bookId);
		return fiction;
	}
}