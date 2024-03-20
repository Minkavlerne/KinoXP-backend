package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.SeatDto;
import org.example.kinoxpbackend.kino.dto.TheaterDto;
import org.example.kinoxpbackend.kino.entity.Seat;
import org.example.kinoxpbackend.kino.entity.Theater;
import org.example.kinoxpbackend.kino.repository.TheaterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;
    private final SeatService seatService;

    public TheaterService(TheaterRepository theaterRepository, SeatService seatService) {
        this.theaterRepository = theaterRepository;
        this.seatService = seatService;
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Theater getTheaterById(int id) {
        return theaterRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Theater not found"));

    }

  
    public TheaterDto createTheater(TheaterDto theaterDto){
        Theater theater = new Theater();
        theater.setName(theaterDto.getName());
        List<Seat> newSeats = new ArrayList<>();
        for (int i = 0; i < theaterDto.getSeatRows(); i++) {
            for (int j = 0; j < theaterDto.getSeatNumbers(); j++) {
                SeatDto seatDto = new SeatDto();
                seatDto.setSeatRow(i);
                seatDto.setSeatNumber(j);
                // Hard coded type for now, not sure if we will handle it in frontend or not
                seatDto.setType("NORMAL");
                SeatDto savedSeatDto = seatService.createSeat(seatDto);
                Seat seat = seatService.getSeatById(savedSeatDto.getId());
                newSeats.add(seat);
            }
        }
        theater.setSeats(newSeats);
        theaterRepository.save(theater);
        return new TheaterDto(theater);
    }

    public TheaterDto updateTheater(int id, TheaterDto theaterDto){
        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Theater not found"));
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


