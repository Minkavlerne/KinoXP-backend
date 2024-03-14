package org.example.kinoxpbackend.kino.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int Id;

    @Column(nullable = false, unique = true)
    private String bookingNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToOne
    private MovieShow movieShowId;

    @OneToMany(mappedBy = "bookingId")
    @JsonBackReference
    private List<BookedSeat> bookedSeats;

    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    public Booking(String bookingNumber, User userId, MovieShow movieShowId, List<BookedSeat> bookedSeats) {
        this.bookingNumber = bookingNumber;
        this.userId = userId;
        this.movieShowId = movieShowId;
        this.bookedSeats = bookedSeats;
    }
}
