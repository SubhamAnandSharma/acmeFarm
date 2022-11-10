package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.CurrentCustomerSession;


@Repository
public interface CustomerSessionDao extends JpaRepository<CurrentCustomerSession, Integer>{
	
	public Optional<CurrentCustomerSession> findByUserId(Integer userId);
	
	public Optional<CurrentCustomerSession> findByUuid(String uuid);
	
}