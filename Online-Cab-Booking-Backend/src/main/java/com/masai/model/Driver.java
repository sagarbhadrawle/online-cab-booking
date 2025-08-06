package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;

@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(nullable = false)
	private String name;
	
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile Number should be exactly ten digits")
	private String mob;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="driver" )
	List<Cab> cab ;
	
}
