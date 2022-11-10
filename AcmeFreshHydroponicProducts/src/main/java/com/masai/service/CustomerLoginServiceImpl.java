package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.CurrentCustomerSession;
import com.masai.models.Customer;
import com.masai.models.CustomerDto;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{

	@Autowired
	private CustomerDao userDao;
	
	@Autowired
	private CustomerSessionDao userSessionDAO;
	
	@Override
	public String logIntoAccount(CustomerDto dto) throws Exception {

		Optional<Customer> opt= userDao.findByMobileNo(dto.getMobileNo());
		
		if(!opt.isPresent()) {
			return "Please enter valid Mobile number!";
		}
		
		Customer user1= opt.get();
		Integer userId = user1.getId();
		Optional<CurrentCustomerSession>  currUseropt1= userSessionDAO.findByUserId(userId);
		
		if(currUseropt1.isPresent()) {
			return "User already logged in with this number.";
		}
		
		if(user1.getPassword().equals(dto.getPassword())) {
			
			String key = RandomString.make(6);
			CurrentCustomerSession currentUserSession = new CurrentCustomerSession(userId, key, LocalDateTime.now());
			
			userSessionDAO.save(currentUserSession);

			return currentUserSession.toString();
		}
		else {
			return "Please Enter valid password.";
		}

		
	}
	

	@Override
	public String logOutAccount(String key) {
		Optional<CurrentCustomerSession> currUserOpt=userSessionDAO.findByUuid(key);
		
		if(currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1=currUserOpt.get();
			
			userSessionDAO.delete(currUser1);
			return "User logged out successfully.";
		}
		return "User does not exist, Enter correct uuid";

	}

}
