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

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.createCategory(categoryDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable int id, @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
