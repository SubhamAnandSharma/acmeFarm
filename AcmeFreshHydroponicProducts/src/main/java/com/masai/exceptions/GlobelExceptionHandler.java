package com.masai.exceptions;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelExceptionHandler {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> AccountExceptionHandler(WebRequest req , ProductException pe){
		
		MyErrorDetails ed = new MyErrorDetails();
		ed.setTimeStamp(LocalDateTime.now());
		ed.setMessage(pe.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(ed, HttpStatus.NOT_ACCEPTABLE);
		
		
	}
	
	@ExceptionHandler(InsufficientFundException.class)
	public ResponseEntity<MyErrorDetails> BalanceExceptionHandler(WebRequest req , InsufficientFundException pe){
		
		MyErrorDetails ed = new MyErrorDetails();
		ed.setTimeStamp(LocalDateTime.now());
		ed.setMessage(pe.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(ed, HttpStatus.NOT_ACCEPTABLE);
		
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> productExceptionHandler(WebRequest req , Exception e){
		
		MyErrorDetails ed = new MyErrorDetails();
		ed.setTimeStamp(LocalDateTime.now());
		ed.setMessage(e.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	
}
