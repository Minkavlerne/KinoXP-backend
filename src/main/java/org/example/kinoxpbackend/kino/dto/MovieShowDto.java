package org.example.kinoxpbackend.kino.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Movie;
import org.example.kinoxpbackend.kino.entity.MovieShow;
import org.example.kinoxpbackend.kino.entity.Theater;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieShowDto {
    private int id;
    private Timestamp startTime;
    private Timestamp endTime;
    private int movie;
    private int theater;

    public MovieShowDto(MovieShow movieShow) {
        this.id = movieShow.getId();
        this.startTime = movieShow.getStartTime();
        this.endTime = movieShow.getEndTime();
        this.movie = movieShow.getMovie().getId();
        this.theater = movieShow.getTheater().getId();
    }
}
