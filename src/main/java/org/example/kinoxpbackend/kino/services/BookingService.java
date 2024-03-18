package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.BookingDto;
import org.example.kinoxpbackend.kino.entity.Booking;
import org.example.kinoxpbackend.kino.repository.BookingRepository;
import org.example.kinoxpbackend.kino.repository.MovieShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    BookingRepository bookingRepository;

    MovieShowRepository movieShowRepository;


    public BookingService(BookingRepository bookingRepository, MovieShowRepository movieShowRepository) {
        this.bookingRepository = bookingRepository;
        this.movieShowRepository = movieShowRepository;
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(BookingDto::new).collect(java.util.stream.Collectors.toList());
    }

    public BookingDto getBookingById(int id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        return new BookingDto(booking);
    }

}
