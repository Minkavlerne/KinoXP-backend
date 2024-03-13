package org.example.kinoxpbackend.kino.repository;

import org.example.kinoxpbackend.kino.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
