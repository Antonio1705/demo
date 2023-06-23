package com.example.demo.Repository;

import com.example.demo.Entity.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film,Integer> {
}
