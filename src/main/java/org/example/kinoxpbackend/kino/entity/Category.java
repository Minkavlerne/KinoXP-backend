package org.example.kinoxpbackend.kino.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Category {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;
   @Column(nullable = false, unique = true)
    private String name;

   @ManyToMany
    @JoinTable(
            name = "movie_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
   @JsonManagedReference
    private List<Movie> movies;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    public Category(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }
}
