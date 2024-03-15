package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.dto.CategoryDto;
import org.example.kinoxpbackend.kino.entity.Category;
import org.example.kinoxpbackend.kino.services.CategoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequestMapping("/categories")
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
