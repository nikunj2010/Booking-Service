package com.cdac.acts.BookingService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdac.acts.BookingService.entity.Booking;

import jakarta.transaction.Transactional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

	Optional<List<Booking>> findByUserId(Long userId);
	
	@Transactional
	@Modifying
	@Query(
			value = "update bookings set status = 'CANCELLED' where id = :id",
			nativeQuery = true
			)
	void cancelBookingById(@Param("id") Long id);
	
	@Query("select b from Booking b where b.status = 'CONFIRMED'")
	public List<Booking> findAllConfirmedBookings();
	
	@Query(value = "select * from bookings where userId = :userId AND status = 'CONFIRMED' ", nativeQuery = true)
	public List<Booking> findAllConfirmedBookingsByUserId(@Param("userId") Long userId);
	
}
