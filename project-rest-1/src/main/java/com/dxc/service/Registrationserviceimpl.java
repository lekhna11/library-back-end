package com.dxc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.model.Book;
import com.dxc.model.User;
import com.dxc.repository.Registrationrepo;

@Service
public class Registrationserviceimpl implements Registrationservice {
	
	@Autowired
	private Registrationrepo registration;

	@Override
	public User save(User user) {

		return registration.save(user);
	}

	@Override
	public User fetchUserByEmailId(String email) {
		
		return registration.findByEmailId(email);
	}

	@Override
	public User fetchUserByEmailIdAndPassword(String email, String password) {
		
		return registration.findByEmailIdAndPassword(email, password);
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return registration.findAll();
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		User users = registration.save(user);
		return users;
	}

	@Override
	public Optional<User> findById(String emailId) {
		// TODO Auto-generated method stub
		Optional<User> user = registration.findById(emailId);
		return registration.findById(emailId);
	}
}