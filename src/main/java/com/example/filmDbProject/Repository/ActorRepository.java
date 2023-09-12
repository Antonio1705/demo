package com.example.filmDbProject.Repository;


import com.example.filmDbProject.Entity.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ActorRepository extends CrudRepository<Actor, Integer> {

    Optional<Actor> findActorByFirstNameAndLastName(String firstName, String lastName);
    List<Actor> findByFirstName(String firstName);
    List<Actor> findByLastName(String lastName);
}
