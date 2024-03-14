package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.entity.BookedSeat;
import org.example.kinoxpbackend.kino.repository.BookedSeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedSeatService {

    BookedSeatRepository bookedSeatRepository;

    public BookedSeatService(BookedSeatRepository bookedSeatRepository) {
        this.bookedSeatRepository = bookedSeatRepository;
    }

    public List<BookedSeat> getAllBookedSeats() {
        return bookedSeatRepository.findAll();
    }
}
