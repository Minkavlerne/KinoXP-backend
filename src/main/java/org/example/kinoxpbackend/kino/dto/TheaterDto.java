package org.example.kinoxpbackend.kino.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Theater;

@Getter
@Setter
@NoArgsConstructor
public class TheaterDto {
    private int id;
    private String name;



    public TheaterDto(Theater theater){
        this.id = theater.getId();
        this.name = theater.getName();
    }

}
