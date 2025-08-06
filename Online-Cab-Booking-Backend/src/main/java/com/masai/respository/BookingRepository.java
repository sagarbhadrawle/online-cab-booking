package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

	
}
