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
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    private Integer id;
    private String name;
    private List<Integer> movieIds;
    private LocalDateTime created;
    private LocalDateTime updated;

    public CategoryDto(Category c, boolean includeMovies) {
        this.id = c.getId();
        this.name = c.getName();
        this.created = c.getCreated();
        this.updated = c.getUpdated();
        if (includeMovies) {
            this.movieIds = c.getMovies().stream().map(Movie::getId).collect(Collectors.toList());
        }
    }
}