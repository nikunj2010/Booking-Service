package com.cdac.acts.BookingService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.acts.BookingService.entity.Booking;
import com.cdac.acts.BookingService.exceptions.BookingCancelException;
import com.cdac.acts.BookingService.exceptions.BookingNotFoundException;
import com.cdac.acts.BookingService.exceptions.CreateBookingException;
import com.cdac.acts.BookingService.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		List<Booking> bookings = bookingRepository.findAllConfirmedBookings();
		
		if(bookings.size() == 0) {
			throw new BookingNotFoundException("No booking found");
		}
		return bookings;
	}

	@Override
	public List<Booking> getAllBookingsByUserId(Long userId) {
		// TODO Auto-generated method stub
		List<Booking> bookings = bookingRepository.findAllConfirmedBookingsByUserId(userId);
		
		if(bookings.size() == 0) {
			throw new BookingNotFoundException("No booking found");
		}
		
		return bookings;
	}

	@Override
	public Booking createNewBooking(Booking booking) {
		// TODO Auto-generated method stub
		try {
			Booking existingBooking = bookingRepository.saveAndFlush(booking);
			
			return existingBooking;
		}
		catch(Exception e) {
			throw new CreateBookingException(e.getMessage());
		}
	}

	@Override
	public Long cancelBooking(Long bookingId) {
		
		if(!bookingRepository.existsById(bookingId)) {
			throw new BookingNotFoundException("No booking found");
		}
		if(bookingRepository.findById(bookingId).get().getStatus().equals("CANCELLED")) {
			throw new BookingCancelException("Booking already cancelled");
		}
		bookingRepository.cancelBookingById(bookingId);		
		return bookingId;
	}
}
