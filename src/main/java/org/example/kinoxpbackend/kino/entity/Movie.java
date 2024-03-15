package org.example.kinoxpbackend.kino.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String posterBase64;

    @Column(nullable = false)
    private String posterUrl;

    @Column(nullable = false)
    private String trailerUrl;

    @Column(nullable = false)
    private int ageLimit;

    @Column(nullable = false)
    private LocalTime duration;

    private LocalDate releaseDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "movie_category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonBackReference
    private List<Category> categories = new ArrayList<>();

    public Movie(String title, String description, String posterBase64, String posterUrl, String trailerUrl, int ageLimit, LocalTime duration, LocalDate releaseDate) {
        this.title = title;
        this.description = description;
        this.posterBase64 = posterBase64;
        this.posterUrl = posterUrl;
        this.trailerUrl = trailerUrl;
        this.ageLimit = ageLimit;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }
}
