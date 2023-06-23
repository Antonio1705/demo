package com.example.demo.Service;

import com.example.demo.Entity.FilmCategory;
import com.example.demo.Entity.FilmCategoryId;
import com.example.demo.Repository.FilmCategoryRepository;
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
