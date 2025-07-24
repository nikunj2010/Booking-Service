package com.cdac.acts.BookingService.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flightId", nullable = false)
    private Long flightId;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "noOfSeats", nullable = false)
    private Integer noOfSeats;

    @Column(name = "totalCost", nullable = false)
    private Integer totalCost;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
