package org.example.kinoxpbackend.kino.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Theater;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TheaterDto {
    private int id;
    private String name;
    private List<Integer> seatIds;
    private List<Integer> movieShowIds;
    private List<Integer> bookedSeatIds;

    public TheaterDto(Theater theater) {
        this.name = theater.getName();
        this.seatIds = theater.getSeats().stream().map(seat -> seat.getId()).toList();
        this.movieShowIds = theater.getMovieShows().stream().map(movieShow -> movieShow.getId()).toList();
        this.bookedSeatIds = theater.getBookedSeats().stream().map(bookedSeat -> bookedSeat.getId()).toList();
    }
}
