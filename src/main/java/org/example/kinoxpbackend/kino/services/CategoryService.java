package org.example.kinoxpbackend.kino.services;

import org.example.kinoxpbackend.kino.dto.CategoryDto;
import org.example.kinoxpbackend.kino.entity.Category;
import org.example.kinoxpbackend.kino.repository.CategoryRepository;
import org.springframework.stereotype.Service;

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

    public CategoryDto addCategory(CategoryDto request) {
        Category category = new Category();
        category.setName(request.getName());

        categoryRepository.save(category);
        return new CategoryDto(category);
    }
}
