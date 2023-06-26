package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.FilmCategory;
import com.example.filmDbProject.Entity.FilmCategoryId;
import com.example.filmDbProject.Repository.FilmCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmCategoryService {
    @Autowired
    FilmCategoryRepository filmCategoryRepository;

    public List<FilmCategory> getAllFilmCategorys(){
        return (List<FilmCategory>)filmCategoryRepository.findAll();
    }

    public List<FilmCategory> getFilmCategoryByIdCategory(Integer idCategory){
        return (List<FilmCategory>)filmCategoryRepository.findFilmCategoryById_CategoryId(idCategory);
    }

    public List<FilmCategory> getFilmCategoryByIdFilm(Integer idFilm){
        return (List<FilmCategory>)filmCategoryRepository.findFilmCategoryById_FilmId(idFilm);
    }

    public FilmCategory getFilmCategoryById(FilmCategoryId filmCategoryId){
        return filmCategoryRepository.findFilmCategoryById(filmCategoryId);
    }

    public FilmCategory saveFilmCategory(FilmCategory filmCategory){
        return filmCategoryRepository.save(filmCategory);
    }

    public void deleteFilmCategory(FilmCategoryId filmCategoryId){
        filmCategoryRepository.deleteFilmCategoryById(filmCategoryId);
    }

    public FilmCategory updateFilmCategory(FilmCategoryId filmCategoryId, FilmCategory filmCategory){
        FilmCategory filmCategoryFindById  = filmCategoryRepository.findFilmCategoryById(filmCategoryId);
        filmCategoryFindById.setLastUpdate(filmCategory.getLastUpdate());
        filmCategoryFindById.setId(filmCategory.getId());
        return filmCategoryRepository.save(filmCategoryFindById);
    }
}
