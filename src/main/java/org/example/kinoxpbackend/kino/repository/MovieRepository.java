package org.example.kinoxpbackend.kino.repository;

import org.example.kinoxpbackend.kino.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer>
{

}
