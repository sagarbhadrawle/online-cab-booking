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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile Number should be exactly ten digits")
	private String mob;

	private Boolean availability = true;

	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "driver")
	List<Cab> cab;

	public Driver(String name,
			@Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile Number should be exactly ten digits") String mob) {
		super();
		this.name = name;
		this.mob = mob;
	}

}
