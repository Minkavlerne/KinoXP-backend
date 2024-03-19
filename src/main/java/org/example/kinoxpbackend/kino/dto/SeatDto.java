package org.example.kinoxpbackend.kino.dto;

import org.example.kinoxpbackend.kino.entity.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatDto {
    private int Id;
    private int seatRow;
    private int seatNumber;
    private String type;

    public SeatDto(Seat seat){
        this.Id = seat.getId();
        this.seatRow = seat.getSeatRow();
        this.seatNumber = seat.getSeatNumber();
        this.type = seat.getType();
    }
}


