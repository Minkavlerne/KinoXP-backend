package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.entity.BookedSeat;
import org.example.kinoxpbackend.kino.repository.BookedSeatRepository;
import org.example.kinoxpbackend.kino.services.BookedSeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/bookedseats")
@RestController
public class BookedSeatController {

    BookedSeatService bookedSeatService;

    public BookedSeatController(BookedSeatService bookedSeatService) {
        this.bookedSeatService = bookedSeatService;
    }

    @GetMapping
    private List<BookedSeat> getAllBookedSeats() {
        return bookedSeatService.getAllBookedSeats();
    }
}
