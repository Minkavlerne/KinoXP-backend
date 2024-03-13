package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.entity.MovieShow;
import org.example.kinoxpbackend.kino.repository.MovieShowRepository;
import org.springframework.stereotype.Service;

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
}
