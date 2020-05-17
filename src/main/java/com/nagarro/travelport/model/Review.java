package com.nagarro.travelport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long documentid ;
	    private String comment ;
	    private String message ;
	    private String mail ;
	    private String ticketNumber ;
	    private String adminmail;
	    private String document ;
	    
		public Long getDocumentid() {
			return documentid;
		}
		public void setDocumentid(Long documentid) {
			this.documentid = documentid;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public String getTicketNumber() {
			return ticketNumber;
		}
		public void setTicketNumber(String ticketNumber) {
			this.ticketNumber = ticketNumber;
		}
		public String getAdminmail() {
			return adminmail;
		}
		public void setAdminmail(String adminmail) {
			this.adminmail = adminmail;
		}
		public String getDocument() {
			return document;
		}
		public void setDocument(String document) {
			this.document = document;
		}
	    
}
