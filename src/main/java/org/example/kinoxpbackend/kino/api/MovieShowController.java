package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.dto.MovieShowDto;
import org.example.kinoxpbackend.kino.entity.MovieShow;
import org.example.kinoxpbackend.kino.entity.Theater;
import org.example.kinoxpbackend.kino.services.MovieShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movieshows")
@RestController
public class MovieShowController {
    private final MovieShowService movieShowService;

    public MovieShowController(MovieShowService movieShowService) {
        this.movieShowService = movieShowService;
    }

    @GetMapping
    public ResponseEntity<List<MovieShowDto>> getAllMovieShows() {
        return ResponseEntity.ok(movieShowService.getAllMovieShows());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieShowDto> getMovieShowById(@PathVariable int id) {
        return ResponseEntity.ok(movieShowService.getMovieShowById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieShow(@PathVariable int id) {
        movieShowService.deleteMovieShow(id);
        return ResponseEntity.noContent().build();
    }
}
