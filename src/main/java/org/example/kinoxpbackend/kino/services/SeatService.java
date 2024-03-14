package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.entity.Seat;
import org.example.kinoxpbackend.kino.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }
    public List<Seat> getAllSeats(){
        return seatRepository.findAll();
    }

}
