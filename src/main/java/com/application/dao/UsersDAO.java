package com.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.core.Users;
import com.application.customRepo.UsersRepositoryCustom;



public interface UsersDAO  extends JpaRepository<Users, String>,UsersRepositoryCustom {
	
	public Users findByLoginId(String loginId) throws Exception;
	
}
