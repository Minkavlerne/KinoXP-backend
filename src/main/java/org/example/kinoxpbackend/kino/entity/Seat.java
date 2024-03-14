package org.example.kinoxpbackend.kino.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @JsonBackReference
    private Theater theater;

    @OneToMany(mappedBy = "seat")
    @JsonBackReference
    private List<BookedSeat> bookedSeat;

    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    public Seat(int seatRow, int seatNumber, String type, Theater theater) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.type = type;
        this.theater = theater;
        this.bookedSeat = new ArrayList<>();
    }
}