package com.example.demo.Repository;

import com.example.demo.Entity.FilmActor;
import com.example.demo.Entity.FilmActorId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmActorRepository extends CrudRepository<FilmActor,FilmActorId> {

    //public FilmActor findFilmActorByFilmActorId(FilmActorId filmActorId);
    public FilmActor findFilmActorById(FilmActorId filmActorId);
    public List<FilmActor> findFilmActorsById_FilmId(Integer filmId);
    public List<FilmActor> findFilmActorsById_ActorId(Integer actorId);
    void deleteFilmActorById(FilmActorId filmActorId);
}
