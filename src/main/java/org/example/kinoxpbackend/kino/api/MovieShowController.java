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
    public ResponseEntity<List<MovieShow>> getAllMovieShows() {
        return ResponseEntity.ok(movieShowService.getAllMovieShows());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieShow> getMovieShowById(@PathVariable int id) {
        return ResponseEntity.ok(movieShowService.getMovieShowById(id));
    }
   @PutMapping("/{id}")
    public ResponseEntity<MovieShowDto> updateMovieShow(@PathVariable int id, @RequestBody MovieShowDto movieShowDto) {
        return ResponseEntity.ok(movieShowService.updateMovieShow(id, movieShowDto));
    }

    @PostMapping
    public ResponseEntity<MovieShowDto> addMovieShow(@RequestBody MovieShowDto movieShowDto) {
        return ResponseEntity.ok(movieShowService.addMovieShow(movieShowDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieShow(@PathVariable int id) {
        movieShowService.deleteMovieShow(id);
        return ResponseEntity.noContent().build();
    }
}
