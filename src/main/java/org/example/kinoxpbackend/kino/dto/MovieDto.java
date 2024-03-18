package org.example.kinoxpbackend.kino.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Category;
import org.example.kinoxpbackend.kino.entity.Movie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@NotNull
public class MovieDto {
    private int id;
    private String title;
    private String description;
    private String posterBase64;
    private String posterUrl;
    private String trailerUrl;
    private int ageLimit;
    private LocalTime duration;
    private LocalDate releaseDate;
    private List<String> categories;

    public MovieDto(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.posterBase64 = movie.getPosterBase64();
        this.posterUrl = movie.getPosterUrl();
        this.trailerUrl = movie.getTrailerUrl();
        this.ageLimit = movie.getAgeLimit();
        this.duration = movie.getDuration();
        this.releaseDate = movie.getReleaseDate();
        this.categories = movie.getCategories().stream().map(Category::getName).toList();

    }


}
