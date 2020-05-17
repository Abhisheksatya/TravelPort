package com.nagarro.travelport.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nagarro.travelport.model.Review;

public interface ReviewDao extends JpaRepository<Review, Long>{

	List<Review> findByMail(String mail);

}
