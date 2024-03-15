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
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public CategoryDto(Category c, boolean includeMovies) {
        this.id = c.getId();
        this.name = c.getName();
        this.created_at = c.getCreated_at();
        this.updated_at = c.getUpdated_at();
        if (includeMovies) {
        }
    }
}