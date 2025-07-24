package com.cdac.acts.BookingService.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cdac.acts.BookingService.responseWrappers.ResponsePayload;


@RestControllerAdvice
public class BookingExceptionHandler {


	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<ResponsePayload<?>> resourceNotFound(BookingNotFoundException e){

		ResponsePayload<Object> res = new ResponsePayload<>(
				"FAILURE",
				e.getMessage(),
				null
				);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
	
	@ExceptionHandler(CreateBookingException.class)
	public ResponseEntity<ResponsePayload<?>> resourceCreate(CreateBookingException e){
		System.out.println("create booking exception handler");
		ResponsePayload<Object> res = new ResponsePayload<>(
				"FAILURE",
				e.getMessage(),
				null
				);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	}
}
