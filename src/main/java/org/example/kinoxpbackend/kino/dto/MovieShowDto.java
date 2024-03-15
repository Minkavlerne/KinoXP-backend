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
    private Timestamp startTime;
    private Timestamp endTime;
}
