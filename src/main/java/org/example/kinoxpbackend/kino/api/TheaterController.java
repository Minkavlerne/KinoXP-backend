package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.dto.TheaterDto;
import org.example.kinoxpbackend.kino.entity.MovieShow;
import org.example.kinoxpbackend.kino.entity.Theater;
import org.example.kinoxpbackend.kino.services.MovieShowService;
import org.example.kinoxpbackend.kino.services.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    TheaterService theaterService;

    MovieShowService movieShowService;

    public TheaterController(TheaterService theaterService, MovieShowService movieShowService) {
        this.theaterService = theaterService;
        this.movieShowService = movieShowService;
    }


    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheaters() {
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable int id) {
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }

    @GetMapping("/{id}/movieshows")
    public ResponseEntity<List<MovieShow>> getMovieShowsByTheaterId(@PathVariable int id) {
        Theater theater = theaterService.getTheaterById(id);
        return ResponseEntity.ok(movieShowService.getAllMovieShowsByTheater(theater));
    }

    @PostMapping
    public ResponseEntity<TheaterDto> createTheater(@RequestBody TheaterDto theaterDto){
        return ResponseEntity.ok(theaterService.createTheater(theaterDto));

  }
    @PutMapping("/{id}")
    public ResponseEntity<TheaterDto> updateTheater(@PathVariable int id, @RequestBody TheaterDto theaterDto){
        return ResponseEntity.ok(theaterService.updateTheater(id, theaterDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TheaterDto> deleteTheaterById(@PathVariable int id) {
        return ResponseEntity.ok(theaterService.deleteTheaterById(id));

    }
}
