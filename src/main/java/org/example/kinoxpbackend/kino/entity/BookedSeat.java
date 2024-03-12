package org.example.kinoxpbackend.kino.entity;

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

    @OneToOne
    private Seat seatId;

    @ManyToOne
    @JoinColumn (name = "theater_id")
    private Theater theaterId;

    @CreationTimestamp
    public LocalDateTime created_at;
}
