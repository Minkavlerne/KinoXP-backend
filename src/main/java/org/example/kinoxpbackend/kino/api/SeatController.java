package org.example.kinoxpbackend.kino.api;


import org.example.kinoxpbackend.kino.dto.SeatDto;
import org.example.kinoxpbackend.kino.entity.Seat;
import org.example.kinoxpbackend.kino.repository.SeatRepository;
import org.example.kinoxpbackend.kino.services.CategoryService;
import org.example.kinoxpbackend.kino.services.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/seats")
@RestController
public class SeatController {
    private final SeatService seatService;

    public SeatController(SeatService seatService){
        this.seatService = seatService;
    }
    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats(){
        return ResponseEntity.ok(seatService.getAllSeats());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SeatDto> getSeatById(@PathVariable int id){
        return ResponseEntity.ok(seatService.getSeatById(id));
    }
    @PostMapping
    public ResponseEntity<SeatDto> createSeat(@RequestBody SeatDto seatDto){
        return ResponseEntity.ok(seatService.createSeat(seatDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SeatDto> updateSeat(@PathVariable int id, @RequestBody SeatDto seatDto){
        return ResponseEntity.ok(seatService.updateSeat(id, seatDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable int id){
        seatService.deleteSeat(id);
        return ResponseEntity.noContent().build();
    }


}
