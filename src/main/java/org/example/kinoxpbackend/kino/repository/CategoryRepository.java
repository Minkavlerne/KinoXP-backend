package org.example.kinoxpbackend.kino.repository;

import org.example.kinoxpbackend.kino.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByName(String name);

}
