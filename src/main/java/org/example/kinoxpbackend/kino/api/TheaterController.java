package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.dto.TheaterDto;
import org.example.kinoxpbackend.kino.entity.Theater;
import org.example.kinoxpbackend.kino.services.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }


    @GetMapping
    public ResponseEntity<List<TheaterDto>> getAllTheaters() {
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheaterDto> getTheaterById(@PathVariable int id) {
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }
}
