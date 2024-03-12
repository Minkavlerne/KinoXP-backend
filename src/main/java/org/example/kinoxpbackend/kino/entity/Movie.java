package org.example.kinoxpbackend.kino.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

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


   @CreationTimestamp
    private LocalDateTime created_at;

   @UpdateTimestamp
    private LocalDateTime updated_at;


}
