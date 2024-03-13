package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.entity.Booking;
import org.example.kinoxpbackend.kino.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
