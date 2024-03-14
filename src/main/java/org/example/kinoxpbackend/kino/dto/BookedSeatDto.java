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
    private boolean isBooked;
    private int seatId;
    private int bookingId;
    private int theaterId;

    public BookedSeatDto(BookedSeat bs) {
        this.id = bs.getId();
        this.isBooked = bs.isBooked();
        this.seatId = bs.getSeatId().getId();
        this.bookingId = bs.getBookingId().getId();
        this.theaterId = bs.getTheaterId().getId();
    }
}
