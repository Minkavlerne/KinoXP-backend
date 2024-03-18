package org.example.kinoxpbackend.kino.services;


import org.example.kinoxpbackend.kino.dto.SeatDto;
import org.example.kinoxpbackend.kino.entity.Seat;
import org.example.kinoxpbackend.kino.repository.SeatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }
    public List<SeatDto> getAllSeats(){
        List<Seat> seats = seatRepository.findAll();
        return seats.stream().map(SeatDto::new).toList();
    }

    public SeatDto getSeatById(int id){
        Seat seat = seatRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat not found"));
        return new SeatDto(seat);
    }
}