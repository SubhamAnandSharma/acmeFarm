package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.Admin;
import com.masai.models.AdminDto;
import com.masai.models.CurrentAdminSession;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminSessionDao adminSessionDAO;

	@Override
	public String logIntoAccount(AdminDto admin){
		

		Optional<Admin> adminObj = adminDao.findByMobileNo(admin.getMobileNo());
		
		if(!adminObj.isPresent()) {
			return "Please enter valid Mobile number!";
		}
		
		Admin admin1 = adminObj.get();
		Integer adminId = admin1.getId();
		
		Optional<CurrentAdminSession>  currAdminopt1= adminSessionDAO.findByAdminId(adminId);
		
		if(currAdminopt1.isPresent()) {
			return "Admin already logged in with this number.";
		}
		
		if(admin1.getPassword().equals(admin.getPassword())) {
			
			String key = RandomString.make(6);
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(adminId, key, LocalDateTime.now());
			
			adminSessionDAO.save(currentAdminSession);
			
			return currentAdminSession.toString();
		}
		else {
			return "Please Enter valid password.";
		}



	
	}

	@Override
	public String logOutAccount(String key) {
		
		Optional<CurrentAdminSession> currAdminOpt=adminSessionDAO.findByUuid(key);
		
		if(currAdminOpt.isPresent()) {
			CurrentAdminSession currAdmin1=currAdminOpt.get();
			
			adminSessionDAO.delete(currAdmin1);
			return "Admin logged out successfully.";
		}
		return "Admin does not exist, Enter correct uuid";
	}

	@Override
	public String logIntoAccount(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
