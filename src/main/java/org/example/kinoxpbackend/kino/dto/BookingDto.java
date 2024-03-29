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
    private int movieShowId;
    private String userName;
    private List<Integer> seatIds;

    public BookingDto(Booking booking) {
        this.id = booking.getId();
        this.movieShowId = booking.getMovieShow().getId();
        this.userName = booking.getUser().getUsername();
        this.seatIds = booking.getSeats().stream().map(Seat::getId).toList();

    }
}
