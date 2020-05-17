package com.nagarro.travelport.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Ticket {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long ticketNumber ;
	    private String requestType ;
	    private String Priority ;
	    private String travelCity ;
	    private String fromLocation ;
	    private Date startDate ;
	    private Date endDate ;
	    private String Passport ;
	    private String Project ;
	    private String Borne ;
	    private String Approver ;
	    private String Duration ;
	    private String boundAmount ;
	    private String Details ;
	    
	    private String mail ;
	    @Column(name = "status",columnDefinition = "varchar(255) default 'SUBMITTED'",updatable = true)
	    private String Status ;
		public String getRequestType() {
			return requestType;
		}
		public void setRequestType(String requestType) {
			this.requestType = requestType;
		}
		public String getPriority() {
			return Priority;
		}
		public void setPriority(String priority) {
			Priority = priority;
		}
		public String getTravelCity() {
			return travelCity;
		}
		public void setTravelCity(String travelCity) {
			this.travelCity = travelCity;
		}
		public String getFromLocation() {
			return fromLocation;
		}
		public void setFromLocation(String fromLocation) {
			this.fromLocation = fromLocation;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public String getPassport() {
			return Passport;
		}
		public void setPassport(String passport) {
			Passport = passport;
		}
		public String getProject() {
			return Project;
		}
		public void setProject(String project) {
			Project = project;
		}
		public String isBorne() {
			return Borne;
		}
		public void setBorne(String borne) {
			Borne = borne;
		}
		public String getApprover() {
			return Approver;
		}
		public void setApprover(String approver) {
			Approver = approver;
		}
		public String getDuration() {
			return Duration;
		}
		public void setDuration(String duration) {
			Duration = duration;
		}
		public String getBoundAmount() {
			return boundAmount;
		}
		public void setBoundAmount(String boundAmount) {
			this.boundAmount = boundAmount;
		}
		public String getDetails() {
			return Details;
		}
		public void setDetails(String details) {
			Details = details;
		}
		public Long getTicketNumber() {
			return ticketNumber;
		}
		public void setTicketNumber(Long ticketNumber) {
			this.ticketNumber = ticketNumber;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}	
}
