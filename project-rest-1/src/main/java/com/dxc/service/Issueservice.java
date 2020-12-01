package com.dxc.service;

import java.util.List;

import com.dxc.model.Issue;

public interface Issueservice {
    
	public Issue save(Issue issue);
	
	public Issue update(Issue issue);
	
	List<Issue> getIssue();

	//public void deleteByIssue(int issue);

	//public Issue findByIssue(int issue);

	public Issue findBybookId(int bookId);

	public void deleteBybookId(int bookId);

}