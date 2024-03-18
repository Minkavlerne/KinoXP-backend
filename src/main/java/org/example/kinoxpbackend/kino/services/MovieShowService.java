package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.MovieDto;
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

        public MovieShowService(MovieShowRepository movieShowRepository, MovieRepository movieRepository, TheaterRepository theaterRepository){
                this.movieShowRepository = movieShowRepository;
                this.movieRepository = movieRepository;
                this.theaterRepository = theaterRepository;
        }
        public List<MovieShowDto> getAllMovieShows(){
                List<MovieShow> movieShows = movieShowRepository.findAll();
                return movieShows.stream().map(MovieShowDto::new).toList();
        }
        public MovieShowDto getMovieShowById(int id){
                MovieShow movieShow = movieShowRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie show not found"));
                return new MovieShowDto(movieShow);
        }

        public MovieShowDto addMovieShow(MovieShowDto movieShowDto){
                MovieShow movieShow = new MovieShow();
                convertToMovieShow(movieShow, movieShowDto);
                movieShowRepository.save(movieShow);
                return new MovieShowDto(movieShow);

        }

        public void deleteMovieShow(int id){
                MovieShow movieShow = movieShowRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie show not found"));
                movieShowRepository.delete(movieShow);
        }

        private void convertToMovieShow(MovieShow movieShow, MovieShowDto movieShowDto){
                movieShow.setMovie(movieRepository.findById(movieShowDto.getMovieId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found")));
                movieShow.setTheater(theaterRepository.findById(movieShowDto.getTheaterId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Theater not found")));
                movieShow.setStartTime(movieShowDto.getStartTime());
                movieShow.setEndTime(movieShowDto.getEndTime());
        }
}

