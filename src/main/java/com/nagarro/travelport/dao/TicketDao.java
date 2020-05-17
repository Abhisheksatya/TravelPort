package com.nagarro.travelport.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.travelport.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, String>{
	List<Ticket> findByMail(String userName);
	public Ticket save(Ticket ticket);
	Ticket findByTicketNumber(Long id);

}
