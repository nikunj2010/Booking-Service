package com.cdac.acts.BookingService.service;

import java.util.List;

import com.cdac.acts.BookingService.entity.Booking;

public interface BookingService {

	public List<Booking> getAllBookings();
	
	public List<Booking> getAllBookingsByUserId(Long userId);
	
	public Booking createNewBooking(Booking booking);
	
	public Long cancelBooking(Long bookingId);
}
