package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dxc.model.Fiction;

public interface Fictionrepo extends JpaRepository<Fiction, Integer> {
	
	public Fiction findBybookId(Integer bookId);

}
