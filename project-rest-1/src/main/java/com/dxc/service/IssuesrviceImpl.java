package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.model.Fiction;
import com.dxc.model.Issue;
import com.dxc.repository.Issuerepo;

@Service
public class IssuesrviceImpl implements Issueservice {
	@Autowired
	Issuerepo issuerepo;

	@Override
	public Issue save(Issue issue) {
		// TODO Auto-generated method stub
		return issuerepo.save(issue);
	}

	@Override
	public Issue update(Issue issue) {
		// TODO Auto-generated method stub
		Issue issues=issuerepo.save(issue);
		return issues;
	}

	@Override
	public List<Issue> getIssue() {
		// TODO Auto-generated method stub
		return issuerepo.findAll();
	}
	

	@Override
	public Issue findBybookId(int bookId) {
		// TODO Auto-generated method stub
		Issue issues=issuerepo.findBybookId(bookId);
		return issues;
	}

	@Override
	public void deleteBybookId(int bookId) {
		Issue issues = issuerepo.findBybookId(bookId);
		issuerepo.delete(issues);
		
	}

}