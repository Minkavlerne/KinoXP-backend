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
private String RowName;
private String ColumnName;
private String type;
}


