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

    public List<TheaterDto> getAllTheaters() {
        List<Theater> theaters = theaterRepository.findAll();
        return theaters.stream().map(TheaterDto::new).collect(toList());
    }

    public TheaterDto getTheaterById(int id) {
        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Theater not found"));
        return new TheaterDto(theater);
    }
}


