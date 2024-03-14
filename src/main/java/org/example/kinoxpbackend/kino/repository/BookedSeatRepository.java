package org.example.kinoxpbackend.kino.repository;

import org.example.kinoxpbackend.kino.entity.BookedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedSeatRepository extends JpaRepository<BookedSeat, Integer> {
}
