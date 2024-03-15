package org.example.kinoxpbackend.kino.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookedSeat {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int Id;

    @CreationTimestamp
    public LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    @JsonManagedReference
    private Seat seat;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "booking_id")
    private Booking bookingId;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn (name = "theater_id")
    private Theater theaterId;


    public BookedSeat(Seat seat, Theater theaterId) {
        this.seat = seat;
        this.theaterId = theaterId;
    }
}
