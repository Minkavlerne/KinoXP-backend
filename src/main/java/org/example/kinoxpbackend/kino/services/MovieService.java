package org.example.kinoxpbackend.kino.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.kinoxpbackend.kino.dto.MovieDto;
import org.example.kinoxpbackend.kino.entity.Category;
import org.example.kinoxpbackend.kino.entity.Movie;
import org.example.kinoxpbackend.kino.repository.CategoryRepository;
import org.example.kinoxpbackend.kino.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(MovieDto::new).collect(toList());
    }
}
