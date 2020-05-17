package com.nagarro.travelport.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.travelport.model.UserLogin;

public interface LoginDao extends JpaRepository<UserLogin, String>{
	
	UserLogin findByMail(String userName);
	UserLogin save(UserLogin userlogin);
	
	
}
