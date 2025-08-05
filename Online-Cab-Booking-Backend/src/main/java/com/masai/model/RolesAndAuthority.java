package com.masai.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class RolesAndAuthority {
	
	
	@jakarta.persistence.Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	
	@Column(unique = true,nullable=false)
	private String name;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roleAndAuthority")
	@ToString.Exclude
	private Set<Customer> customerSet;


	public RolesAndAuthority(String name) {
		super();
		this.name = name;
	}
	
	
	
}
