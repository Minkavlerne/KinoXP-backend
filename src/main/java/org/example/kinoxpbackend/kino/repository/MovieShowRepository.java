package org.example.kinoxpbackend.kino.repository;

import org.example.kinoxpbackend.kino.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {

}
