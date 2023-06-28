package com.example.filmDbProject.Repository;

import com.example.filmDbProject.Entity.Film;
import com.example.filmDbProject.Entity.FilmProjection;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface FilmRepository extends CrudRepository<Film,Integer> {
    Optional<FilmProjection> findByTitle(String title);


}
