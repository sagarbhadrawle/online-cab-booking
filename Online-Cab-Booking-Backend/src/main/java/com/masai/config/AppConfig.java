package com.masai.config;

import java.util.Arrays;
import java.util.Collections;

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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
//@ComponentScan(basePackages = {"com.masai"})
@EnableWebSecurity
public class AppConfig {
	
	@Bean
	public SecurityFilterChain anyMethodName(HttpSecurity http) throws Exception{
		
			http.cors(cors -> {

			cors.configurationSource(new CorsConfigurationSource() {

				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
					CorsConfiguration cfg = new CorsConfiguration();

					cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
					cfg.setAllowedMethods(Collections.singletonList("*"));
					cfg.setAllowCredentials(true);
					cfg.setAllowedHeaders(Collections.singletonList("*"));
					cfg.setExposedHeaders(Arrays.asList("Authorization"));
					return cfg;
				}
			});

		}).authorizeHttpRequests(
					
					auth -> auth.requestMatchers(HttpMethod.POST, "/customers").permitAll()
					.requestMatchers(HttpMethod.POST,"/cabs", "/booking/*/*").permitAll()
					.requestMatchers(HttpMethod.DELETE,"booking/*").permitAll()
					.requestMatchers(HttpMethod.GET,"viewBooking/*").permitAll()
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
