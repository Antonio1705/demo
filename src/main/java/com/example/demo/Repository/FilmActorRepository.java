package com.example.demo.Repository;

import com.example.demo.Entity.FilmActor;
import com.example.demo.Entity.FilmActorId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmActorRepository extends CrudRepository<FilmActor,Integer> {

    //public FilmActor findFilmActorByFilmActorId(FilmActorId filmActorId);
    public FilmActor findFilmActorById(FilmActorId filmActorId);
    public List<FilmActor> findFilmActorsById_FilmId(FilmActorId filmId);
    public List<FilmActor> findFilmActorsById_ActorId(FilmActorId actorId);
    void deleteFilmActorById(FilmActorId filmActorId);
}
