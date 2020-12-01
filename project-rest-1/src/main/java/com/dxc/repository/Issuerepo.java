package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.Issue;

public interface Issuerepo extends JpaRepository<Issue, Integer> {

	 //public Issue findByIssue(int issue);

	public Issue findBybookId(int bookId);

}