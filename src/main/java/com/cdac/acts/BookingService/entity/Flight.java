package com.cdac.acts.BookingService.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "flights")
public class Flight {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private Long id;

	    @Column(name = "flightNumber", nullable = false, unique = true)
	    private String flightNumber;

	    @Column(name = "airplaneId", nullable = false)
	    private Long airplaneId;

	    @OneToMany(mappedBy = "flight")
	    @JsonIgnore
	    private List<Booking> booking;

	    @Column(name = "departureTime", nullable = false)
	    private LocalDateTime departureTime;

	    @Column(name = "arrivalTime", nullable = false)
	    private LocalDateTime arrivalTime;

	    @Column(name = "price", nullable = false)
	    private Integer price;

	    @Column(name = "boardingGate")
	    private String boardingGate;

	    @Column(name = "totalSeats", nullable = false)
	    private Integer totalSeats;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;
	    
	    @Column(name = "availableSeats")
	    int availableSeats;
}
