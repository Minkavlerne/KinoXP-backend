package org.example.kinoxpbackend.kino.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp startTime;

    private Timestamp endTime;

    @ManyToOne
    @JoinColumn(name="movie_id")
    @JsonManagedReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    @JsonManagedReference
    private Theater theater;

    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    public MovieShow(Timestamp startTime, Timestamp endTime, Movie movie, Theater theater) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.theater = theater;
    }
}
