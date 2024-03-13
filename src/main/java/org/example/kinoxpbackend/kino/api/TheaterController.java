package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.entity.Theater;
import org.example.kinoxpbackend.kino.services.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
