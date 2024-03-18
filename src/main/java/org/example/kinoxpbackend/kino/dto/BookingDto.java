package org.example.kinoxpbackend.kino.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Booking;
import org.example.kinoxpbackend.kino.entity.Seat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookingDto {
    private int id;
    private String bookingNumber;
    private int movieShowId;
    private String userName;
    private List<Integer> seatId;

    public BookingDto(Booking booking) {
        this.id = booking.getId();
        this.bookingNumber = booking.getBookingNumber();
        this.movieShowId = booking.getMovieShow().getId();
        this.userName = booking.getUser().getUsername();
        this.seatId = booking.getSeats().stream().map(Seat::getId).toList();

    }
}
