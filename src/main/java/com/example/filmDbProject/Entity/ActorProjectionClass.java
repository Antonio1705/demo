package com.example.filmDbProject.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ActorProjectionClass{
    private String actorName;
    private String actorLastname;

    public ActorProjectionClass(Actor actor){
        this.actorLastname = actor.getLastName();
        this.actorName = actor.getFirstName();
    }
}
