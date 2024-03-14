package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.MovieShowDto;
import org.example.kinoxpbackend.kino.entity.Movie;
import org.example.kinoxpbackend.kino.entity.MovieShow;
import org.example.kinoxpbackend.kino.entity.Theater;
import org.example.kinoxpbackend.kino.repository.MovieRepository;
import org.example.kinoxpbackend.kino.repository.MovieShowRepository;
import org.example.kinoxpbackend.kino.repository.TheaterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieShowService {
    private final MovieShowRepository movieShowRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;

    public MovieShowService(MovieShowRepository movieShowRepository, MovieRepository movieRepository, TheaterRepository theaterRepository) {
        this.movieShowRepository = movieShowRepository;
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
    }

    public List<MovieShow> getAllMovieShows() {
        return movieShowRepository.findAll();
    }

    public MovieShow getMovieShowById(int id) {
        return movieShowRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "MovieShow not found"));
    }

    public ResponseEntity deleteMovieShow(int id) {
        MovieShow movieShow = movieShowRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "MovieShow not found"));
        movieShowRepository.delete(movieShow);
        return new ResponseEntity(("Movie Show deleted"), org.springframework.http.HttpStatus.OK);
    }

    public MovieShow addMovieShow(MovieShowDto request) {
        MovieShow movieShow = new MovieShow();
        updateMovieShow(movieShow, request);

        movieShowRepository.save(movieShow);
        return movieShow;

    }

    public MovieShowDto editMovieShow(MovieShowDto request, int id) {
        if (request.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of the movie Show.");
        }
        MovieShow movieShow = movieShowRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "MovieShow not found"));
       updateMovieShow(movieShow, request);

        movieShowRepository.save(movieShow);
        return new MovieShowDto(movieShow);


    }

    private void updateMovieShow(MovieShow orginal, MovieShowDto request) {
        orginal.setStartTime(request.getStartTime());
        orginal.setEndTime(request.getEndTime());
        Movie movie = movieRepository.findById(request.getMovie()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        orginal.setMovie(movie);
        Theater theater = theaterRepository.findById(request.getTheater()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Theater not found"));
        orginal.setTheater(theater);
    }
}
