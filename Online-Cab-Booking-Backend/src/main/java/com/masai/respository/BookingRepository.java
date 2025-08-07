package com.masai.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

	
	@Query("SELECT b FROM Booking b JOIN b.customer c WHERE c.customerId = :customerId")
	List<Booking> getBookingsByCustomerId(@Param("customerId") Integer customerId);

	
}
