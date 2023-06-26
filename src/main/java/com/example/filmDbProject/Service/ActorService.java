package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Actor;

public interface ActorService {

    Actor getActor(int idActor);
    Actor saveActor(Actor actor);
    void  delete(int id);
    Actor updateActor(int idActor, Actor actor);

}
