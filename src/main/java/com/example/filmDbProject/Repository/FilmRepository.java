package com.example.filmDbProject.Repository;

import com.example.filmDbProject.Entity.Film;
import org.springframework.data.repository.CrudRepository;


public interface FilmRepository extends CrudRepository<Film,Integer> {
}
