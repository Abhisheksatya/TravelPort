package com.nagarro.travelport.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelport.model.Review;
import com.nagarro.travelport.model.Ticket;
import com.nagarro.travelport.model.UserLogin;
import com.nagarro.travelport.service.UserServices;



@RestController
@RequestMapping("/rest")
public class UserResources {
	
	@Autowired
	private UserServices userService;
	
	
	
	@RequestMapping("/user/users")
	public void loginSuccess(){
		System.out.println("login successfully");
	}
	
	@RequestMapping(value="/user/booking", method=RequestMethod.POST)
	public Ticket findByUserName(@RequestBody Ticket ticket) {
		ticket.setStatus("SUBMITTED");
		return userService.save(ticket);
	}
	
	
	@RequestMapping(value="/user/viewTicket", method=RequestMethod.POST)
	public List<Ticket> findTicket(@RequestBody Map<String,String> json) {
		String userName = json.get("mail");
		List<Ticket> ticket= userService.findByMail1(userName);
		return ticket;
	}
	
//	@RequestMapping(value="/user/ticketById", method=RequestMethod.POST)
//	public Ticket findTicketbyid(Ticket ticket) {
//		Long ticketnumber=ticket.getTicketNumber();
//		ticket=userService.findOne(ticketnumber);
//		return ticket;
//	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Ticket getTicketid(@PathVariable("id") Long id){
		
		return userService.findOne(id);
	}
	
	@RequestMapping(value="/user/AdminviewTicket", method=RequestMethod.POST)
	public List<Ticket> AdminfindTicket(@RequestBody Map<String,String> json) {
		//String userName = json.get("mail");
		List<Ticket> ticket= userService.find();
		return ticket;
	}
	
	@RequestMapping(value="/user/reset", method=RequestMethod.POST)
	public UserLogin resetPassword(@RequestBody Map<String,String> json) throws ServletException, IOException {
		if(json.get("mail") == null || json.get("password")==""||json.get("temp")=="" ) {
			throw new ServletException("Please fill in details");
		}
		String userName = json.get("mail");
		String password = json.get("password");
		String value= json.get("temp");
		UserLogin user = userService.findByMail(userName);
		if(user == null) {
			throw new ServletException ("User name not found.");
		}
		String pwd = user.getPassword();
		String pwdd=user.getTemp();
		if (password.equals(pwd)||password.equals(pwdd)) {
			user.setPassword(value);
			user.setTemp("");
			userService.signin(user);
			
		}
		else {
			throw new ServletException("Invalid login. Please check your username and password");
		}
		user.setPassword("Password reset Successfully");
		return user;
	}
	
	@RequestMapping(value="/user/ticketupdate", method=RequestMethod.POST)
	public Ticket updateBookPost(@RequestBody Ticket tick) {
		//tick.setStatus("RE SUBMITTED ");
		return userService.update(tick);
	}
	
	@RequestMapping(value="/user/review", method=RequestMethod.POST)
	public Review review(@RequestBody Review review) {
		return userService.save(review);
	}
	
	@RequestMapping(value="/user/getreview", method=RequestMethod.POST)
	public List<Review> getreview(@RequestBody Review review) {
		return userService.findByMail3(review.getMail());
		 
	}
	
	
	
	   
	 
}
