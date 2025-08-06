package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@ComponentScan(basePackages = {"com.masai"})
@EnableWebSecurity
public class AppConfig {
	
	@Bean
	public SecurityFilterChain anyMethodName(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(
				
				auth -> auth.requestMatchers(HttpMethod.POST, "/customers").permitAll()
				.requestMatchers(HttpMethod.POST,"/cabs").permitAll()
				 .requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
				.anyRequest().authenticated())
		.csrf(c -> c.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	
}
