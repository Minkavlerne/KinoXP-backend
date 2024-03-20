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

    public List<Seat> getAllSeats(){
        return seatRepository.findAll();
    }

    public Seat getSeatById(int id){
        return seatRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat not found"));
    }

    public SeatDto createSeat(SeatDto seatDto){
        Seat seat = new Seat(seatDto.getSeatRow(), seatDto.getSeatNumber(), seatDto.getType());
        seatRepository.save(seat);
        return new SeatDto(seat);
    }

    public SeatDto updateSeat(int id, SeatDto seatDto){
        Seat seat = seatRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat not found"));
        seat.setSeatRow(seatDto.getSeatRow());
        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setType(seatDto.getType());
        seatRepository.save(seat);
        return new SeatDto(seat);
    }

    public void deleteSeat(int id){
        seatRepository.deleteById(id);
    }

}