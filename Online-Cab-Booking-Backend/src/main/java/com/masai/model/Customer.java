package com.masai.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Customer implements UserDetails , CredentialsContainer {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@Column(nullable=false)
	private String name;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	
	@Column(unique=true, nullable= false)
	private String email;
	
	@NotBlank
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone Number should be exactly ten digits")
	private String contact;
	
	@JoinTable(name = "customer_authorities", joinColumns = {@JoinColumn(name="customer_id")},
			
			inverseJoinColumns = {@JoinColumn(name = "role_and_authority_id")}
			
	)
	
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private Set<RolesAndAuthority> roleAndAuthority = new HashSet<>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		Set<SimpleGrantedAuthority> set = new HashSet<>();
		for(RolesAndAuthority roles : roleAndAuthority )
		{
			set.add(new SimpleGrantedAuthority(roles.getName()));
		}
		
		return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		
	}

}
