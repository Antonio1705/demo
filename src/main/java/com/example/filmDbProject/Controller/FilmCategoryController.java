package com.example.filmDbProject.Controller;


import com.example.filmDbProject.Entity.FilmCategory;
import com.example.filmDbProject.Entity.FilmCategoryId;
import com.example.filmDbProject.Service.FilmCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmCategory")
public class FilmCategoryController {
    @Autowired
    FilmCategoryService filmCategoryService;

    @GetMapping
    public ResponseEntity<List<FilmCategory>> getAllFilmCategorys(){
        return new ResponseEntity<>(filmCategoryService.getAllFilmCategorys(), HttpStatus.FOUND);
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<List<FilmCategory>> getAllFilmCategorysByFilmId(@PathVariable Integer id){
        return new ResponseEntity<>(filmCategoryService.getFilmCategoryByIdFilm(id), HttpStatus.FOUND);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<FilmCategory>> getAllFilmCategorysByCategoryId(@PathVariable Integer id){
        return new ResponseEntity<>(filmCategoryService.getFilmCategoryByIdCategory(id), HttpStatus.FOUND);
    }

    @GetMapping("/film/{filmId}/category/{categoryId}")
    public ResponseEntity<FilmCategory> getAllFilmCategorysByCategoryId(@PathVariable Integer filmId, @PathVariable Integer categoryId){
        FilmCategoryId filmCategoryId = new FilmCategoryId(filmId,categoryId);
        return new ResponseEntity<>(filmCategoryService.getFilmCategoryById(filmCategoryId), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<FilmCategory> saveFilmCategory(@RequestBody FilmCategory filmCategory){
        return new ResponseEntity<>(filmCategoryService.saveFilmCategory(filmCategory),HttpStatus.CREATED);
    }

    @PutMapping("/film/{filmId}/category/{categoryId}")
    public ResponseEntity<FilmCategory> updateFilmCategory(@RequestBody FilmCategory filmCategory,@PathVariable Integer filmId, @PathVariable Integer categoryId){
        FilmCategoryId filmCategoryId = new FilmCategoryId(filmId,categoryId);
        return new ResponseEntity<>(filmCategoryService.updateFilmCategory(filmCategoryId,filmCategory),HttpStatus.CREATED);
    }

    @DeleteMapping("/film/{filmId}/category/{categoryId}")
    public ResponseEntity<HttpStatus> deleteFilmCategory(@PathVariable Integer filmId, @PathVariable Integer categoryId){
        filmCategoryService.deleteFilmCategory(new FilmCategoryId(filmId,categoryId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
