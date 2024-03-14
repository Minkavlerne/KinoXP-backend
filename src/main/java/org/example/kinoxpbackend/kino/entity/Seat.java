package org.example.kinoxpbackend.kino.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seatRow;
    private int seatNumber;
    private String type;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    public Seat(int seatRow, int seatNumber, boolean isReserved, String type, Theater theater) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
        this.type = type;
        this.theater = theater;
    }
}