package com.example.filmDbProject.Repository;

import com.example.filmDbProject.Entity.FilmActor;
import com.example.filmDbProject.Entity.FilmActorId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmActorRepository extends CrudRepository<FilmActor,FilmActorId> {

    //public FilmActor findFilmActorByFilmActorId(FilmActorId filmActorId);
    public FilmActor findFilmActorById(FilmActorId filmActorId);
    public List<FilmActor> findFilmActorsById_FilmId(Integer filmId);
    public List<FilmActor> findFilmActorsById_ActorId(Integer actorId);
    void deleteFilmActorById(FilmActorId filmActorId);
}
