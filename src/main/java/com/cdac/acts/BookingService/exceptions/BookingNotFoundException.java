package com.cdac.acts.BookingService.exceptions;

public class BookingNotFoundException extends RuntimeException{

	public BookingNotFoundException(String message) {
		
		super(message);
	}
}
