package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(SomethingWentWrong.class)
	public ResponseEntity<ErrorDetails> myException(SomethingWentWrong ex , WebRequest wb)
	{
		ErrorDetails ed = new ErrorDetails(ex.getMessage(), wb.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorDetails> customerNotFound(CustomerNotFoundException ex , WebRequest wb)
	{
		ErrorDetails ed = new ErrorDetails(ex.getMessage(), wb.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST); 
	}
}
