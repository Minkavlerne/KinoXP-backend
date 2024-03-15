package org.example.kinoxpbackend.kino.dto;


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
}


