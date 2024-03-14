package org.example.kinoxpbackend.kino.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Booking;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookingDto {
    private int id;
    private String bookingNumber;
    private int userId;
    private int movieShowId;
    private List<Integer> bookedSeats;

    public BookingDto(Booking b){
        this.id = b.getId();
        this.bookingNumber = b.getBookingNumber();
        this.userId = b.getUserId().getId();
        this.movieShowId = b.getMovieShowId().getId();
        this.bookedSeats = b.getBookedSeats().stream().map(bs -> bs.getSeat().getId()).toList();
    }

}
