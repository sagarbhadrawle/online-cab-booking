package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class OnlineCabBookingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCabBookingBackendApplication.class, args);
		log.debug("inside main");
	}

}
