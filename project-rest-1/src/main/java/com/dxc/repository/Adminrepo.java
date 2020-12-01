package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.Admin;

public interface Adminrepo extends JpaRepository<Admin, Integer> {

	 public String findByEmailId(String emailId);

	public String  findByEmailIdAndPassword(String emailId, String password);
	

}
