package com.cdac.acts.BookingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.acts.BookingService.entity.Booking;
import com.cdac.acts.BookingService.responseWrappers.ResponsePayload;
import com.cdac.acts.BookingService.service.BookingServiceImpl;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingServiceImpl bookingService;
	
	@GetMapping
	public ResponsePayload<List<Booking>> getAllBookings(){
		List<Booking> bookings = bookingService.getAllBookings();
		
		ResponsePayload<List<Booking>> res = new ResponsePayload<List<Booking>>(
				"SUCCESS" , 
				"Bookings fetched successfully" , 
				bookings);
		
		return res;
	}
	
	@GetMapping("/{userId}")
	public ResponsePayload<List<Booking>> getAllBookingsByUserId(@PathVariable Long userId){
		List<Booking> bookings = bookingService.getAllBookingsByUserId(userId);
		
		ResponsePayload<List<Booking>> res = new ResponsePayload<List<Booking>>(
				"SUCCESS" , 
				"Bookings fetched successfully" , 
				bookings);
		
		return res;
	}
	@PostMapping
	public ResponsePayload<Booking> createNewBooking(@RequestBody Booking booking){
		Booking createdBooking = bookingService.createNewBooking(booking);
		
		ResponsePayload<Booking> res = new ResponsePayload<Booking>(
				"SUCCESS" , 
				"Bookings created successfully" , 
				createdBooking);
		
		return res;
	}
	
	@DeleteMapping("/{id}")
	public ResponsePayload<Long> cancelBooking(@PathVariable Long id){
		id = bookingService.cancelBooking(id);
		ResponsePayload<Long> res = new ResponsePayload<Long>(
				"SUCCESS" , 
				"Bookings cancelled successfully" , 
				id);
		
		return res;
	}
}
