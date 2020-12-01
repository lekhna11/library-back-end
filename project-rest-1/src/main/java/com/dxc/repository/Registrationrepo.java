package com.dxc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.User;

public interface Registrationrepo extends JpaRepository<User, String> {
	
	public User findByEmailId(String emailId);
	
	public User findByEmailIdAndPassword(String emailId, String password);
	
	public Optional<User> findById(String emailId);

}