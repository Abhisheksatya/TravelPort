package com.nagarro.travelport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLogin {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long userId;
		@Column(name = "mail")
		private String mail ;
		@Column(name = "password")
		private String password ;
		@Column 
		private String temp;

			public String getTemp() {
				return temp;
			}
			public void setTemp(String temp) {
				this.temp = temp;
			}
			public Long getUserId() {
				return userId;
			}
			public void setUserId(Long userId) {
				this.userId = userId;
			}
			public String getMail() {
				return mail;
			}
			public void setMail(String mail) {
				this.mail = mail;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
}
