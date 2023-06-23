package com.example.demo.Service;

import com.example.demo.Entity.Actor;

public interface ActorService {

    Actor getActor(int idActor);
    Actor saveActor(Actor actor);
    void  delete(int id);
    Actor updateActor(int idActor, Actor actor);

}
