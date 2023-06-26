package com.example.filmDbProject.Controller;

import com.example.filmDbProject.Entity.FilmActor;
import com.example.filmDbProject.Entity.FilmActorId;
import com.example.filmDbProject.Service.FilmActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("filmactor")
public class FilmActorController {

    @Autowired
    FilmActorService filmActorService;

    @GetMapping("/filmId/{filmId}/actorId/{actorId}")
    public ResponseEntity<FilmActor> getFilmActorByIds(@PathVariable Integer filmId, @PathVariable Integer actorId){
        FilmActorId filmActorId = new FilmActorId(actorId,filmId);
        return new ResponseEntity<>(filmActorService.getFilmActorByIds(filmActorId), HttpStatus.FOUND);
    }

    @GetMapping("/filmId/{filmId}")
    public ResponseEntity<List<FilmActor>> getFilmActorByFilmId(@PathVariable Integer filmId){

        return new ResponseEntity<>(filmActorService.getFilmActorsByFilmId(filmId), HttpStatus.FOUND);
    }

    @GetMapping("/actorId/{actorId}")
    public ResponseEntity<List<FilmActor>> getFilmActorByActorId( @PathVariable Integer actorId){
        return new ResponseEntity<>(filmActorService.getFilmActorsByActorId(actorId), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<FilmActor>> getFilmActorAll(){
        return new ResponseEntity<>(filmActorService.getFilmActorsAll(), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<FilmActor> saveFilmActor(@RequestBody FilmActor filmActor){
        return new ResponseEntity<>(filmActorService.saveFilmActor(filmActor),HttpStatus.CREATED);
    }

    @PutMapping("/filmId/{filmId}/actorId/{actorId}")
    public ResponseEntity<FilmActor> updateFilmActor(@PathVariable Integer filmId, @PathVariable Integer actorId, @RequestBody FilmActor filmActor){
        return new ResponseEntity<>(filmActorService.updateFilmActor(filmId,actorId,filmActor),HttpStatus.OK);
    }

    @DeleteMapping("/filmId/{filmId}/actorId/{actorId}")
    public ResponseEntity<HttpStatus> deleteFilmActor(@PathVariable Integer filmId, @PathVariable Integer actorId){
        filmActorService.deleteFilmActor(filmId,actorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
