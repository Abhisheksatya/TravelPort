package com.nagarro.travelport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nagarro.travelport.model.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{
	User findByMail(String mail);
}
