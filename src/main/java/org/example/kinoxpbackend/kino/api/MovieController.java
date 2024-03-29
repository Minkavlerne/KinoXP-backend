package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.dto.MovieDto;
import org.example.kinoxpbackend.kino.entity.Movie;
import org.example.kinoxpbackend.kino.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movies")
@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable int id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {
        return ResponseEntity.ok(movieService.addMovie(movieDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> editMovie(@PathVariable int id, @RequestBody MovieDto request) {
        return ResponseEntity.ok(movieService.editMovie(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
