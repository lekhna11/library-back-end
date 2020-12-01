package com.dxc.service;

import java.util.List;

import com.dxc.model.Fiction;



public interface Fictionservice {
    
	public Fiction save(Fiction fiction);
	
	public Fiction update(Fiction fiction);
	
	List<Fiction> getBooks();

	public void deleteBybookId(int bookId);

	public Fiction findBybookId(int bookId);

}
