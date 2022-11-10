package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.AdminDto;
import com.masai.models.CustomerDto;
import com.masai.service.AdminLoginServiceImpl;
import com.masai.service.CustomerLoginServiceImpl;



@RestController
public class LoginController {

//	@Autowired
//	private CustomerLoginServiceImpl customerLoginServiceImpl;
//
//	@Autowired
//	private AdminLoginServiceImpl adminLoginServiceImpl;
//
//	// for user login
//	@PostMapping("/Customerlogin")
//	public String logInUser(@RequestBody CustomerDto userDTO) throws Exception {
//		return customerLoginServiceImpl.logIntoAccount(userDTO);
//	}
//
//	// for user logout
//	@PatchMapping("/Customerlogout")
//	public String logOutUser(@RequestParam(required = false) String key) {
//		return customerLoginServiceImpl.logOutAccount(key);
//	}
//
//	// for admin login
//	@PostMapping("/adminlogin")
//	public String logInAdmin(@RequestBody AdminDto adminDTO) {
//		return adminLoginServiceImpl.logIntoAccount(adminDTO);
//	}
//
//	// for admin logout
//	@PatchMapping("/adminlogout")
//	public String logOutAdmin(@RequestParam(required = false) String key) {
//		return adminLoginServiceImpl.logOutAccount(key);
//	}
	
}

