package com.masai.service;

import com.masai.models.Admin;
import com.masai.models.AdminDto;

public interface AdminLoginService {

	public String logIntoAccount(Admin admin);
	
	public String logOutAccount(String key);

	String logIntoAccount(AdminDto adminDTO);
	
}
