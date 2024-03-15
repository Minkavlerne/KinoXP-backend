package org.example.kinoxpbackend.kino.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Category;
import org.example.kinoxpbackend.kino.entity.Movie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Integer id;
    private String name;
}