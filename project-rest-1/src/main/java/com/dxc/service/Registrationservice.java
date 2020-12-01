package com.dxc.service;


import java.util.List;
import java.util.Optional;

import com.dxc.model.User;

public interface Registrationservice {
	
	List<User> getUser();
	
	public User save(User user);
	
	public User update(User user);
	
	public User fetchUserByEmailId(String email);
	
	public User fetchUserByEmailIdAndPassword(String email, String password);

	public Optional<User> findById(String emailId);

}
