package com.nagarro.travelport.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.travelport.dao.LoginDao;
import com.nagarro.travelport.dao.ReviewDao;
import com.nagarro.travelport.dao.TicketDao;
import com.nagarro.travelport.dao.UserDao;
import com.nagarro.travelport.model.Review;
import com.nagarro.travelport.model.Ticket;
import com.nagarro.travelport.model.User;
import com.nagarro.travelport.model.UserLogin;
import com.nagarro.travelport.service.UserServices;

@Service
public class UserServiceImpl implements UserServices{

	@Autowired 
	private UserDao userDao;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public UserLogin findByMail(String userName) {
		return loginDao.findByMail(userName);
	}
	
	public List<User> findAll(){
		return userDao.findAll();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public UserLogin signin(UserLogin userlogin) {
		// TODO Auto-generated method stub
		return loginDao.save(userlogin);
	}

	@Override
	public Ticket save(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketDao.save(ticket);
	}

	@Override
	public List<Ticket> findByMail1(String userName) {
		// TODO Auto-generated method stub
		return ticketDao.findByMail(userName);
	}
	@Override
	public List<Ticket> find() {
		// TODO Auto-generated method stub
		return ticketDao.findAll();
	}

	@Override
	public User findByMail2(String mail) {
		// TODO Auto-generated method stub
		return userDao.findByMail(mail);
	}

	@Override
	public Ticket findOne(Long id) {
		// TODO Auto-generated method stub
		return ticketDao.findByTicketNumber(id);
	}

	@Override
	public Ticket update(Ticket tick) {
		// TODO Auto-generated method stub
		return ticketDao.save(tick);
	}

	@Override
	public User findOne(String mail) {
		// TODO Auto-generated method stub
		return userDao.findByMail(mail);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public Review save(Review review) {
		// TODO Auto-generated method stub
		return reviewDao.save(review);
	}

	@Override
	public List<Review> findByMail3(String mail) {
		// TODO Auto-generated method stub
		return reviewDao.findByMail(mail);
	}
}
