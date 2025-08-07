package com.masai.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {

	 List<Cab> findByIsAvailableTrue();
}
