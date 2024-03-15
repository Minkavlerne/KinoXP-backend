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
    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;}
    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    @GetMapping(path ="/{id}")
    public Theater getTheaterById(@PathVariable int id) {
        return theaterService.getTheaterById(id);
    }

    @PostMapping
    public Theater addTheater(@RequestBody Theater request) {
        return theaterService.addTheater(request);
    }

    @PutMapping(path = "/{id}")
    public Theater addTheater(@RequestBody Theater request,@PathVariable int id) {
        return theaterService.editTheater(request,id);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteTheater(@PathVariable int id) {
        return theaterService.deleteTheater(id);
    }
}

