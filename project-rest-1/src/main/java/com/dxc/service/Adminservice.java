package com.dxc.service;

import com.dxc.model.Admin;


public interface Adminservice {
    
	public boolean save(Admin admin);
	
	public String fetchByEmailId(String emailId);
	
	public String fetchByEmailIdAndPassword(String EmailId, String password);


}
