package com.example.demo.Repository;

import com.example.demo.Entity.FilmCategory;
import com.example.demo.Entity.FilmCategoryId;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {
    public FilmCategory findFilmCategoryById(FilmCategoryId id);
    public List<FilmCategory> findFilmCategoryById_FilmId(Integer filmId);
    public List<FilmCategory> findFilmCategoryById_CategoryId(Integer categoryId);
    @Transactional
    public void deleteFilmCategoryById(FilmCategoryId id);


}
