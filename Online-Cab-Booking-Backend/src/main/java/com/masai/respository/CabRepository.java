package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {

}
