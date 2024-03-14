package org.example.kinoxpbackend.kino.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.BookedSeat;

@Getter
@Setter
@NoArgsConstructor
public class BookedSeatDto {
    private int id;
    private int seatId;
    private int bookingId;
    private int theaterId;

    public BookedSeatDto(BookedSeat bs) {
        this.seatId = bs.getSeat().getId();
        this.id = bs.getId();
        this.bookingId = bs.getBookingId().getId();
        this.theaterId = bs.getTheaterId().getId();
    }
}
