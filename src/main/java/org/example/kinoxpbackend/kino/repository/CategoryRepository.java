package org.example.kinoxpbackend.kino.repository;

import org.example.kinoxpbackend.kino.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
