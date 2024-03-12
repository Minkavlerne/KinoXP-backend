package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.entity.Movie;
import org.example.kinoxpbackend.kino.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MovieService {
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}
