package com.nagarro.travelport.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelport.PasswordGenerator;
import com.nagarro.travelport.model.Token;
import com.nagarro.travelport.model.User;
import com.nagarro.travelport.model.UserLogin;
import com.nagarro.travelport.service.UserServices;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("user")
public class UserController {
	
	private String sender="abhisatya23@gmail.com";
	private String Password="abhishek38";

	@Autowired
	private UserServices userService;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public Token login(@RequestBody Map<String, String> json) throws ServletException {
		if(json.get("mail") == null || json.get("password") == null) {
			throw new ServletException("Please fill in username and password");
		}
		String userName = json.get("mail");
		String password = json.get("password");
		UserLogin user = userService.findByMail(userName);
		if(user == null) {
			throw new ServletException ("User name not found.");
		}
		String pwd = user.getPassword();
		String pwdd=user.getTemp();
		if (password.equals(pwd)||password.equals(pwdd)) {	}
		else {
			throw new ServletException("Invalid login. Please check your username and password");
		}
		Token token= new Token();
		token.setToken(Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact());
		return	token;
	}
	
	@RequestMapping(value="/{mail}", method = RequestMethod.GET)
	public User getUser(@PathVariable("mail") String mail){
		return userService.findOne(mail);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User registerUser(@RequestBody User user) throws ServletException, AddressException, MessagingException, IOException {
		String mail=user.getMail();
		if(userService.findByMail2(mail)!=null) {
			throw new ServletException("MailId Not available");
		}
		User serve=userService.save(user);
		if(serve==null) {
			throw new ServletException("Invalid Registration");
		}
		else {
			registerUser(serve.getMail());
		}
		return serve;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public User UpdateUser(@RequestBody User user) throws ServletException, AddressException, MessagingException, IOException {
		String mail=user.getMail();
		User serve=userService.update(user);
		if(serve==null) {
			throw new ServletException("Invalid Registration");
		}
		else {
			registerUser(serve.getMail());
		}
		return serve;
	}
	
	@RequestMapping(value="forgetPassword", method=RequestMethod.POST)
	public UserLogin forgetPassword(@RequestBody Map<String, String> json) throws ServletException, MessagingException, IOException {
		if(json.get("mail") == null ) {
			throw new ServletException("Please fill in username");
		}
		String userName = json.get("mail");
		UserLogin user = userService.findByMail(userName);
		String temppass=PasswordGenerator.generateRandomPassword();
		user.setTemp(temppass);
		if(userService.signin(user) != null) {
			String subject="Temporary Password for Nagarro Travel Portal ";
			String Content="Your Temporary Password is "+user.getTemp()+ ".  After Login reset your password.";
			user.setPassword("");
			mailed(user.getMail(),subject,Content);
			user.setTemp("");
			return user;
		}
		else {
			throw new ServletException("Invalid login. Please check your username");
		}
	}
	
	
	@GetMapping("users")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	public  UserLogin registerUser(String mailId) throws AddressException, MessagingException, IOException {
		UserLogin userlogin=new UserLogin();
		userlogin.setMail(mailId);
		String temppass=PasswordGenerator.generateRandomPassword();
		userlogin.setTemp(temppass);
		String subject="Nagarro Travel Portal Information";
		String content="You have requested your user name and password for the your access to the Nagarro Travel Portal:\r\n" + 
				"\r\n" + 
				"Usename: "+mailId+" " + 
				"Password: "+temppass+"" + 
				"";
		//mailed(mailId, subject, content);
		return userService.signin(userlogin);
		
	}
	
	
	 public void mailed(String reciver,String subject,String content) throws AddressException, MessagingException, IOException {
	       Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(sender, Password);
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress(reciver, false));
		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciver));
		   msg.setSubject(subject);
		   msg.setContent(content, "text/html");
		   msg.setSentDate(new Date());
		   Transport.send(msg); 
		   return;
		}
}


