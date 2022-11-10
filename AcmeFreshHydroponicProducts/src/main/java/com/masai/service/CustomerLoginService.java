package com.masai.service;

import com.masai.models.CustomerDto;

public interface CustomerLoginService {

	public String logIntoAccount(CustomerDto userDTO) throws Exception;
	
	public String logOutAccount(String key);
	
}
