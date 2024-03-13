package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.dto.MovieDto;
import org.example.kinoxpbackend.kino.entity.Movie;
import org.example.kinoxpbackend.kino.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movies")
@RestController
public class MovieController {
MovieService movieService;

    public MovieController (MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }


    @PostMapping
    public MovieDto addMovie(@RequestBody MovieDto request) {
        return movieService.addMovie(request);
    }
}
