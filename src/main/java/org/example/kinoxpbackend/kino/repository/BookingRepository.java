package org.example.kinoxpbackend.kino.repository;

import org.example.kinoxpbackend.kino.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findAllByMovieShowId(int id);
}
