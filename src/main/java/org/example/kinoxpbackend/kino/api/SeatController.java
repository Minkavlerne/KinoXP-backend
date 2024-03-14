package org.example.kinoxpbackend.kino.api;


import org.example.kinoxpbackend.kino.dto.SeatDto;
import org.example.kinoxpbackend.kino.entity.Seat;
import org.example.kinoxpbackend.kino.services.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/seats")
@RestController
public class SeatController {
    SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<SeatDto> getAllSeats() {
        return seatService.getAllSeats();
    }
}
