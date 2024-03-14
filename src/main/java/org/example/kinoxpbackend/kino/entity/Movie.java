package org.example.kinoxpbackend.kino.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie {

    @jakarta.persistence.Id
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


   @ManyToMany(mappedBy = "movies")
    private List<Category> categories;

   @OneToMany(mappedBy = "movie")
   @JsonBackReference
    private List<MovieShow> movieShows;

   @CreationTimestamp
    private LocalDateTime created_at;

   @UpdateTimestamp
    private LocalDateTime updated_at;

    public Movie(String title, String description, String posterBase64, String posterUrl, String trailerUrl, int ageLimit, LocalTime duration) {
        this.title = title;
        this.description = description;
        this.posterBase64 = posterBase64;
        this.posterUrl = posterUrl;
        this.trailerUrl = trailerUrl;
        this.ageLimit = ageLimit;
        this.duration = duration;
        this.categories = new ArrayList<>();
    }
}
