package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.dto.BookingDto;
import org.example.kinoxpbackend.kino.entity.Booking;
import org.example.kinoxpbackend.kino.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bookings")
@RestController
public class BookingController {
    BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BookingDto getBookingById(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public BookingDto addBooking(@RequestBody BookingDto request) {
        return bookingService.addBooking(request);
    }
}
