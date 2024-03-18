package org.example.kinoxpbackend.kino.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.security.entity.UserWithRoles;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(nullable = false, unique = true)
    private String bookingNumber;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    private MovieShow movieShow;

    @OneToMany
    private List<Seat> seats = new ArrayList<>();

    @ManyToOne
    private UserWithRoles user;

    @PrePersist
    public void generateBookingNumber() {
        this.bookingNumber = "BookingNumber: " + UUID.randomUUID();
    }

    public Booking(MovieShow movieShow, UserWithRoles user) {
        this.movieShow = movieShow;
        this.user = user;
    }

}
