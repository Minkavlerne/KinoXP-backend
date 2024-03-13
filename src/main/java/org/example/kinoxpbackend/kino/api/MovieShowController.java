package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.entity.MovieShow;
import org.example.kinoxpbackend.kino.services.MovieShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieshows")
public class MovieShowController {
    private MovieShowService movieShowService;

    public MovieShowController(MovieShowService movieShowService) {
        this.movieShowService = movieShowService;
    }
@GetMapping
    public List<MovieShow> getAllMovieShows() {
        return movieShowService.getAllMovieShows();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteMovieShow(@PathVariable int id) {
        return movieShowService.deleteMovieShow(id);
    }
}
