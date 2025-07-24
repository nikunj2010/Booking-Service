package com.cdac.acts.BookingService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.acts.BookingService.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

	Optional<List<Booking>> findByUserId(Long userId);
}
