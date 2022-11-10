package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.CurrentAdminSession;


@Repository
public interface AdminSessionDao extends JpaRepository<CurrentAdminSession, Integer>{

	public Optional<CurrentAdminSession> findByAdminId(Integer adminId);
	
	public Optional<CurrentAdminSession> findByUuid(String uuid);
	
}