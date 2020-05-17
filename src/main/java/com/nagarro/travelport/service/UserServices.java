package com.nagarro.travelport.service;

import java.util.List;

import com.nagarro.travelport.model.Review;
import com.nagarro.travelport.model.Ticket;
import com.nagarro.travelport.model.User;
import com.nagarro.travelport.model.UserLogin;

public interface UserServices {
	
	UserLogin signin(UserLogin userlogin);
	UserLogin findByMail(String userName);
		
	User findOne(String mail);
	User update(User user);
	User save(User user);
	User findByMail2(String mail);
	public List<User> findAll();
	
	Ticket save(Ticket ticket);
	List<Ticket> findByMail1(String userName);
	List<Ticket> find();
	Ticket findOne(Long id);
	Ticket update(Ticket tick);
	
	Review save(Review review);
	List<Review> findByMail3(String mail);
}
