package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Actor;
import com.example.filmDbProject.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{
    @Autowired
    ActorRepository actorRepository;

    @Override
    public Actor getActor(Integer idActor) {
        if (idActor == null){
            return null;
        }
        Optional<Actor> actor = actorRepository.findById(idActor);
        if (actor.isPresent()){
            return actor.get();
        }
        return null;
    }

    @Override
    public Actor getActorByFirstAndLastName(String firstname, String lastname) {
        Optional<Actor> actor = actorRepository.findActorByFirstNameAndLastName(firstname,lastname);

        if (actor.isPresent()){
            return  actor.get();
        }
        return  null;
    }

    @Override
    public List<Actor> findByFirstName(String firstName) {
        if (firstName == null){
            return null;
        }

        List<Actor> actorList = actorRepository.findByFirstName(firstName);


        return actorList;
    }

    @Override
    public List<Actor> findByLastName(String lastName) {
        if (lastName == null){
            return null;
        }

        List<Actor> actor = actorRepository.findByLastName(lastName);

        return actor;
    }

    @Override
    public Actor saveActor(Actor actor) {
        if (actor == null){
            return null;
        }
        return actorRepository.save(actor);
    }

    @Override
    public void delete(Integer id) {
        if (id == null){

        }else {
            actorRepository.deleteById(id);
        }

    }

    @Override
    public Actor updateActor(Integer idActor, Actor actor) {
        if (idActor==null || actor == null){
            return null;
        }

        Optional<Actor> actor1 = actorRepository.findById(idActor);
        if (actor1.isPresent()){
            Actor actorGet = actor1.get();
            actorGet.setLastUpdate(actor.getLastUpdate());
            actorGet.setLastName(actor.getLastName());
            actorGet.setFirstName(actor.getFirstName());
            return actorRepository.save(actorGet);
        }else {
            return null;
        }
    }

    @Override
    public List<Actor> getActors() {
        return (List<Actor>) actorRepository.findAll();
    }
}