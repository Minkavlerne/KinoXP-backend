package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.entity.Movie;
import org.example.kinoxpbackend.kino.entity.MovieShow;
import org.example.kinoxpbackend.kino.entity.Theater;
import org.example.kinoxpbackend.kino.repository.MovieShowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieShowService {
    private MovieShowRepository movieShowRepository;

    public MovieShowService(MovieShowRepository movieShowRepository) {
        this.movieShowRepository = movieShowRepository;
    }
    public List<MovieShow> getAllMovieShows() {
        return movieShowRepository.findAll();
    }


    public ResponseEntity deleteMovieShow(int id){
        MovieShow movieShow = movieShowRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"MovieShow not found"));
        movieShowRepository.delete(movieShow);
        return new ResponseEntity(("Movie Show deleted"), org.springframework.http.HttpStatus.OK);
    }
    public MovieShow addMovieShow(MovieShow request){
        MovieShow movieShow = new MovieShow();
        movieShow.setStartTime(request.getStartTime());
        movieShow.setEndTime(request.getEndTime());
        movieShow.setMovie(request.getMovie());
        movieShow.setTheater(request.getTheater());

        movieShowRepository.save(movieShow);
        return movieShow;

    }


}
