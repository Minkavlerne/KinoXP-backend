package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.MovieDto;
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
public MovieDto addMovie(MovieDto request) {
Movie movie = new Movie();
movie.setTitle(request.getTitle());
movie.setDescription(request.getDescription());
movie.setPosterBase64(request.getPosterBase64());
movie.setPosterUrl(request.getPosterUrl());
movie.setTrailerUrl(request.getTrailerUrl());
movie.setAgeLimit(request.getAgeLimit());
movie.setDuration(request.getDuration());

movieRepository.save(movie);
return new MovieDto(movie);
}
}
