package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.BookingDto;
import org.example.kinoxpbackend.kino.entity.Booking;
import org.example.kinoxpbackend.kino.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public BookingDto getBookingById(int id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
        return new BookingDto(booking);
    }
}
