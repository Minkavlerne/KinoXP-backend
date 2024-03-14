package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.services.SeatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/seats")
@RestController
public class SeatController {
    SeatService seatService;
}
