package org.example.kinoxpbackend.kino.repository;

import org.example.kinoxpbackend.kino.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
