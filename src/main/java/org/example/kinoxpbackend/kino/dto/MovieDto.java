package org.example.kinoxpbackend.kino.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Movie;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@NotNull
public class MovieDto {
    private int Id;
    private String title;
    private String description;
    private String posterBase64;
    private String posterUrl;
    private String trailerUrl;
    private int ageLimit;
    private LocalTime duration;

    public MovieDto(Movie m){
        this.Id = m.getId();
        this.title = m.getTitle();
        this.description = m.getDescription();
        this.posterBase64 = m.getPosterBase64();
        this.posterUrl = m.getPosterUrl();
        this.trailerUrl = m.getTrailerUrl();
        this.ageLimit = m.getAgeLimit();
        this.duration = m.getDuration();
    }
}
