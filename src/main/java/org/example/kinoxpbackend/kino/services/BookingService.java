package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.BookingDto;
import org.example.kinoxpbackend.kino.entity.Booking;
import org.example.kinoxpbackend.kino.entity.Seat;
import org.example.kinoxpbackend.kino.repository.BookingRepository;
import org.example.kinoxpbackend.kino.repository.MovieShowRepository;
import org.example.kinoxpbackend.kino.repository.SeatRepository;
import org.example.kinoxpbackend.security.repository.UserWithRolesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    BookingRepository bookingRepository;

    MovieShowRepository movieShowRepository;

    SeatRepository seatRepository;

    UserWithRolesRepository userRepository;


    public BookingService(BookingRepository bookingRepository, MovieShowRepository movieShowRepository, SeatRepository seatRepository, UserWithRolesRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.movieShowRepository = movieShowRepository;
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(BookingDto::new).collect(java.util.stream.Collectors.toList());
    }

    public BookingDto getBookingById(int id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        return new BookingDto(booking);
    }

    public BookingDto addBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        convertToBooking(bookingDto, booking);
        bookingRepository.save(booking);
        return new BookingDto(booking);
    }

    public BookingDto deleteBooking(int id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            bookingRepository.deleteById(id);
            return new BookingDto(booking.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found");
        }
    }

    private void convertToBooking(BookingDto request, Booking booking) {
        booking.setMovieShow(movieShowRepository.findById(request.getMovieShowId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie show not found")));
        booking.setUser(userRepository.findByUsername(request.getUserName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")));
        List<Seat> seats = new ArrayList<>();
        for (int seatId : request.getSeatIds()) {
            Seat seat = seatRepository.findById(seatId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat not found"));
            seats.add(seat);
        }
        booking.setSeats(seats);
    }

}
