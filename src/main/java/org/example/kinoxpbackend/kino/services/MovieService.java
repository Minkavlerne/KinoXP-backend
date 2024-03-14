package org.example.kinoxpbackend.kino.services;

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
    private final CategoryRepository categoryRepository;

    public MovieService(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream().map(MovieDto::new).collect(toList());
    }

    public MovieDto getMovieById(int id){
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        return new MovieDto(movie);
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
        movie.setCategories(convertToCategoryEntities(request.getCategories()));

        movieRepository.save(movie);
        return new MovieDto(movie);
    }

    public MovieDto editMovie(MovieDto request, int id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setPosterBase64(request.getPosterBase64());
        movie.setPosterUrl(request.getPosterUrl());
        movie.setTrailerUrl(request.getTrailerUrl());
        movie.setAgeLimit(request.getAgeLimit());
        movie.setDuration(request.getDuration());
        movie.setCategories(convertToCategoryEntities(request.getCategories()));

        movieRepository.save(movie);
        return new MovieDto(movie);
    }

    public ResponseEntity deleteMovie(int id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        movieRepository.delete(movie);
        return new ResponseEntity(HttpStatus.OK);
    }

    // Helper function
    private List<Category> convertToCategoryEntities(List<String> categoryNames) {
        return categoryNames.stream().map(name -> categoryRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"))).collect(toList());
    }

}
