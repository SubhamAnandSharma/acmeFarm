package com.masai.repository;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Customer;


@Repository
public interface CustomerDao extends JpaRepository<User, Integer>{
	
	public Optional<Customer> findByMobileNo(String mobileNo);
	
}

