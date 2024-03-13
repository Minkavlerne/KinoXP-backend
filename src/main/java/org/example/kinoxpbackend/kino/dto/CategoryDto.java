package org.example.kinoxpbackend.kino.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kinoxpbackend.kino.entity.Category;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    private Integer id;
    private String name;
    private LocalDateTime created;
    private LocalDateTime updated;

    public CategoryDto(Category c) {
        this.id = c.getId();
        this.name = c.getName();
        this.created = c.getCreated();
        this.updated = c.getUpdated();
    }
}