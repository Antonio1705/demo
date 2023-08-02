package com.example.filmDbProject.Repository;


import com.example.filmDbProject.Entity.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ActorRepository extends CrudRepository<Actor, Integer> {


    Optional<Actor> findByFirstName(String firstName);
    Optional<Actor> findByLastName(String lastName);
}
