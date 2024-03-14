package org.example.kinoxpbackend.kino.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Seat;

@Getter
@Setter
@NoArgsConstructor
@NotNull
public class SeatDto {
    private int Id;
    private int seatRow;
    private int seatNumber;
    private String type;
    private int theaterId;

    public SeatDto(Seat seat) {
        this.Id = seat.getId();
        this.seatRow = seat.getSeatRow();
        this.seatNumber = seat.getSeatNumber();
        this.type = seat.getType();
        this.theaterId = seat.getTheater().getId();
    }
}


