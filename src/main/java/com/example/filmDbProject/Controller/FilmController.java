package com.example.filmDbProject.Controller;

import com.example.filmDbProject.Entity.Actor;
import com.example.filmDbProject.Entity.Film;
import com.example.filmDbProject.Entity.FilmProjection;
import com.example.filmDbProject.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping("/{id}")
    public ResponseEntity<FilmProjection> getFilm(@PathVariable int id){
        return new ResponseEntity<>(filmService.getFilmProjection(id), HttpStatus.FOUND);
    }

    @GetMapping("/{id}/actors")
    public ResponseEntity<List<Actor>> getFilmActors(@PathVariable int id){
        return new ResponseEntity<>(filmService.getFilm(id).getActorList(), HttpStatus.FOUND);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<FilmProjection> getFilmActors(@PathVariable String title){
        FilmProjection filmProjection = filmService.getFilmByTitle(title);
        ResponseEntity<FilmProjection> tResponseEntity = new ResponseEntity<>(filmProjection, HttpStatus.FOUND);
        return tResponseEntity;
    }

    @PostMapping
    public ResponseEntity<FilmProjection> saveFilm(@RequestBody Film film){
        return new ResponseEntity<>(filmService.saveFilm(film), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable int id, @RequestBody Film film){
        return new ResponseEntity<>(filmService.updateFilm(id,film),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFilm(@PathVariable int id){
        filmService.deleteFilm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Film>> getFilms(){
        return new ResponseEntity<>(filmService.getFilmAll(),HttpStatus.FOUND);
    }
}