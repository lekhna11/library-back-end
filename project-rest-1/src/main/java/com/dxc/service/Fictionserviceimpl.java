package com.dxc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.model.Book;
import com.dxc.model.Fiction;
import com.dxc.repository.Fictionrepo;

@Service
public class Fictionserviceimpl implements Fictionservice {
	
	@Autowired
	public Fictionrepo fictionRepo;

	@Override
	public Fiction save(Fiction fiction) {
		// TODO Auto-generated method stub
		return fictionRepo.save(fiction);
	}

	@Override
	public Fiction update(Fiction fiction) {
		// TODO Auto-generated method stub
		Fiction fictions = fictionRepo.save(fiction);
		return fictions;
		
	}

	@Override
	public List<Fiction> getBooks() {
		// TODO Auto-generated method stub
		return fictionRepo.findAll();
	}

	@Override
	public void deleteBybookId(int bookId) {
		// TODO Auto-generated method stub
		Fiction fiction = fictionRepo.findBybookId(bookId);
		fictionRepo.delete(fiction);

		
	}

	@Override
	public Fiction findBybookId(int bookId) {
		// TODO Auto-generated method stub
		Fiction fiction = fictionRepo.findBybookId(bookId);
		return fictionRepo.findBybookId(bookId);
	}

	

}