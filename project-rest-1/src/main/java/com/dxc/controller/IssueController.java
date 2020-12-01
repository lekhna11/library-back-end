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

import com.dxc.model.Issue;
import com.dxc.service.Issueservice;


@RestController
public class IssueController {
	@Autowired
	Issueservice service;
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("issues")
	public List<Issue> getIssue()
	{
		return service.getIssue();
	}
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping(path = "issue/{bookId}")
	public void delete(@PathVariable("bookId") int bookId)
	{
		service.deleteBybookId(bookId);
	
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("issue")
	public Issue save(@RequestBody Issue issue)
	{
		return service.save(issue);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("issue")
	public Issue update(@RequestBody Issue issue)
	{
		return service.update(issue);
	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path = "issue/{bookId}")
	public Issue getIssue(@PathVariable("bookId") int bookId) {
		Issue issue = service.findBybookId(bookId);
		return issue;
	}


}