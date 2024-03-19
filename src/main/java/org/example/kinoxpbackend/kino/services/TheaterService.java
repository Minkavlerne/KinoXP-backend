package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.TheaterDto;
import org.example.kinoxpbackend.kino.entity.Theater;
import org.example.kinoxpbackend.kino.repository.SeatRepository;
import org.example.kinoxpbackend.kino.repository.TheaterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Theater getTheaterById(int id) {
        return theaterRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Theater not found"));

    }

  
    public TheaterDto updateTheater(int id, TheaterDto theaterDto){
        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Theater not found"));
        theater.setName(theaterDto.getName());
        theaterRepository.save(theater);
        return new TheaterDto(theater);
    }
    public TheaterDto createTheater(TheaterDto theaterDto){
        Theater theater = new Theater();
        theater.setName(theaterDto.getName());
        theaterRepository.save(theater);
         return new TheaterDto(theater);
    }
  
    public TheaterDto deleteTheaterById(int id){
        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Theater not found"));
        theaterRepository.deleteById(id);
        return new TheaterDto(theater);
    }
}


