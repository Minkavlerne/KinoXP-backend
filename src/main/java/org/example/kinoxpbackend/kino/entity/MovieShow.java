package org.example.kinoxpbackend.kino.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Movie movieId;
    @OneToOne
    private Theater theaterId;

}