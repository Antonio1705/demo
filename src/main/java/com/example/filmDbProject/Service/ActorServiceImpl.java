package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Actor;
import com.example.filmDbProject.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService{
    @Autowired
    ActorRepository actorRepository;

    @Override
    public Actor getActor(int idActor) {
        Actor actor = actorRepository.findById(idActor).get();
        return actor;
    }

    @Override
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public void delete(int id) {
        actorRepository.deleteById(id);
    }

    @Override
    public Actor updateActor(int idActor, Actor actor) {
        Actor actor1 = actorRepository.findById(idActor).get();
        actor1.setLastUpdate(actor.getLastUpdate());
        actor1.setLastName(actor.getLastName());
        actor1.setFirstName(actor.getFirstName());


        return actorRepository.save(actor1);
    }
}
