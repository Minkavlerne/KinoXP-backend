package org.example.kinoxpbackend.kino.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Booking;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BookingDto {
    private int id;
    private String bookingNumber;
    private int movieShowId;
    private String userName;

    public BookingDto(Booking booking) {
        this.id = booking.getId();
        this.bookingNumber = booking.getBookingNumber();
        this.movieShowId = booking.getMovieShow().getId();
        this.userName = booking.getUser().getUsername();
    }
}
