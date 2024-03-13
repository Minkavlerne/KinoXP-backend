package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.entity.Theater;
import org.example.kinoxpbackend.kino.repository.TheaterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {
    private TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }
        public List<Theater> getAllTheaters() {
            return theaterRepository.findAll();
    }
    public ResponseEntity deleteTheater(int id){
        Theater theater = theaterRepository.findById(id).orElseThrow(()-> new RuntimeException("Theater not found"));
        theaterRepository.delete(theater);
        return new ResponseEntity(("Theater deleted"), org.springframework.http.HttpStatus.OK);
    }
    public Theater addTheater(Theater request){
        Theater theater = new Theater();
        theater.setName(request.getName());

        theaterRepository.save(theater);
        return theater;

    }
}

