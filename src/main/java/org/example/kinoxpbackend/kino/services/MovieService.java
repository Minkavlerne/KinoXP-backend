package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.MovieDto;
import org.example.kinoxpbackend.kino.entity.Category;
import org.example.kinoxpbackend.kino.entity.Movie;
import org.example.kinoxpbackend.kino.repository.CategoryRepository;
import org.example.kinoxpbackend.kino.repository.MovieRepository;
import org.springframework.http.HttpStatus;
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
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(MovieDto::new).collect(toList());
    }

    public MovieDto getMovieById(int id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        return new MovieDto(movie);
    }

    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        updateMovie(movie, movieDto);
        movieRepository.save(movie);
        return new MovieDto(movie);
    }

    public MovieDto editMovie(MovieDto request, int id) {
        try {
            if (request.getId() != id) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of an existing movie");
            }
        Movie movieToEdit = movieRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        System.out.println(request.toString());
        updateMovie(movieToEdit, request);
        System.out.println(movieToEdit);
        movieRepository.save(movieToEdit);
        return new MovieDto(movieToEdit);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void updateMovie(Movie movie, MovieDto movieDto) {
        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        movie.setPosterBase64(movieDto.getPosterBase64());
        movie.setPosterUrl(movieDto.getPosterUrl());
        movie.setTrailerUrl(movieDto.getTrailerUrl());
        movie.setAgeLimit(movieDto.getAgeLimit());
        movie.setDuration(movieDto.getDuration());
        movie.setReleaseDate(movieDto.getReleaseDate());
        List<Category> categories = movieDto.getCategories().stream().map(categoryName -> categoryRepository.findByName(categoryName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"))).toList();
        movie.setCategories(categories);
    }

}
