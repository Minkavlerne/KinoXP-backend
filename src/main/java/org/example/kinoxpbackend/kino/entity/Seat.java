package org.example.kinoxpbackend.kino.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Seat {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;

    @Column(nullable = false)
    private String rowNumber;
    @Column(nullable = false)
    private String seatNumber;

    private boolean isReserved;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
}
