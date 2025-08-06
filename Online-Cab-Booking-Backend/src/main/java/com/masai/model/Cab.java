package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Cab {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String type;
	
	
	private Double perKmRate;
	
	
	private Boolean isAvailable;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "Driver_id")
	Driver driver ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cabs")
	List<Booking> cab;
	
	public Cab( String type,  Double perKmRate,  Boolean isAvailable) {
		super();
		this.type = type;
		this.perKmRate = perKmRate;
		this.isAvailable = isAvailable;
	}
	
	
	
}
