package com.nagarro.travelport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long userId;
		@Column(name = "mail")
		private String mail ;
		@Column(name = "firstName")
		private String firstName;
		@Column(name = "lastName")
		private String lastName;
		@Column(name = "Business")
		private String Business;
		@Column(name = "Title")
		private String Title;
		@Column(name = "Telephone")
		private String Telephone;
		@Column(name = "Address")
		private String Address;
		@Column(name = "Address2")
		private String Address2;
		@Column(name = "City")
		private String City;
		@Column(name = "State")
		private String State;
		@Column(name = "Zip")
		private String Zip;
		@Column(name = "country")
		private String country;
		
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getBusiness() {
			return Business;
		}
		public void setBusiness(String business) {
			Business = business;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getTelephone() {
			return Telephone;
		}
		public void setTelephone(String telephone) {
			Telephone = telephone;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public String getAddress2() {
			return Address2;
		}
		public void setAddress2(String address2) {
			Address2 = address2;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
		public String getZip() {
			return Zip;
		}
		public void setZip(String zip) {
			Zip = zip;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
}
