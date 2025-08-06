package com.masai.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String URI;

	public ErrorDetails(String uRI, String message, LocalDateTime timestamp) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		URI = uRI;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getURI() {
		return URI;
	}
	public void setURI(String uRI) {
		URI = uRI;
	}
}
