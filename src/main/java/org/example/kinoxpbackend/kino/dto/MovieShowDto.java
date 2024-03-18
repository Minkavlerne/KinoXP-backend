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
public class MovieShowDto {
    private int id;
    private int movieId;
    private Timestamp startTime;
    private Timestamp endTime;
    private int theaterId;

    public MovieShowDto(MovieShow movieShow) {
        this.id = movieShow.getId();
        this.movieId = movieShow.getMovie().getId();
        this.startTime = movieShow.getStartTime();
        this.endTime = movieShow.getEndTime();
        this.theaterId = movieShow.getTheater().getId();
    }
}


