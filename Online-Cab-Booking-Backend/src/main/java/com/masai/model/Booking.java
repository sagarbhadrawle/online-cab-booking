package com.masai.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Booking {
		
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="customer_id")
	Customer customer;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cab_id")
	Cab cabs;
	
	@NotNull
	private String source;

	@NotNull
	private String destination;
	
	@NotNull
	private Double distance;
	
	
	private Double totalAmount;
	
	 @Enumerated(EnumType.STRING)
	private BookingStatus status;
	 
//	 private LocalDateTime dateTime;

	 public Booking(com.masai.model.Customer customer, Cab cabs, @NotNull String source, @NotNull String destination,
			@NotNull Double distance, Double totalAmount, BookingStatus status, LocalDateTime dateTime) {
		super();
		this.customer = customer;
		this.cabs = cabs;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.totalAmount = totalAmount;
		this.status = status;
		
	 }
	 
	 
	 
	 
}
