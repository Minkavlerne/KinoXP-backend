package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.CategoryDto;
import org.example.kinoxpbackend.kino.entity.Category;
import org.example.kinoxpbackend.kino.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<String> getAllCategories() {
        List<Category> categories =  categoryRepository.findAll();
        //Convert from list of Categories to DTO-type, list of Strings
        return categories.stream().map((c)->new String(c.getName())).toList();
    }

    public CategoryDto getCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        return new CategoryDto(category);
    }

    public CategoryDto addCategory(CategoryDto request) {
        Category category = new Category();
        category.setName(request.getName());

        categoryRepository.save(category);
        return new CategoryDto(category);
    }

    public CategoryDto editCategory(CategoryDto request, int id) {
        Category categoryToEdit = categoryRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categoryToEdit.setName(request.getName());
        categoryRepository.save(categoryToEdit);
        return new CategoryDto(categoryToEdit);
    }

    public CategoryDto deleteCategory(int id) {
        Category categoryToDelete = categoryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categoryRepository.delete(categoryToDelete);
        return new CategoryDto(categoryToDelete);
    }
}
