package org.example.kinoxpbackend.kino.api;

import org.example.kinoxpbackend.kino.dto.CategoryDto;
import org.example.kinoxpbackend.kino.entity.Category;
import org.example.kinoxpbackend.kino.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")

public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<String> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public CategoryDto addCategory(@RequestBody CategoryDto request) {
        return categoryService.addCategory(request);
    }
}
