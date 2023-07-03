package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Actor;
import com.example.filmDbProject.Entity.Film;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ActorServiceImplTest {


    @Autowired
    ActorServiceImpl actorService;


    @Test
    void getActorById_notNull_success() {


        Actor actor = actorService.getActor(7);

        Assertions.assertThat(actor).isNotNull();
        Assertions.assertThat(actor.getFirstName()).isEqualTo("GRACE");
    }

    @Test
    void getActorById_notExist_null() {

        Actor actor = actorService.getActor(100000);

        Assertions.assertThat(actor).isNull();
    }

    @Test
    void getActorById_null_null() {

        Actor actor = actorService.getActor(null);

        Assertions.assertThat(actor).isNull();
    }


    @Test
    void getActors_list_success() {
        List<Actor> actorList = actorService.getActors();

        Assertions.assertThat(actorList).isNotNull();
        Assertions.assertThat(actorList.size()).isGreaterThan(2);

    }


    @Test
    void saveActor_newActor_success() {
        List<Film> filmList = new ArrayList<>();

        Actor actor = new Actor(1,"aaa","bbb",LocalDate.now(),filmList);
        Actor actorSaved =actorService.saveActor(actor);

        Assertions.assertThat(actorSaved).isNotNull();
        Assertions.assertThat(actorSaved.getFirstName()).isEqualTo("aaa");
        Assertions.assertThat(actorSaved.getFilmList()).isEmpty();
    }

    @Test
    void saveActor_null_null() {
        List<Film> filmList = new ArrayList<>();

        Actor actorSaved =actorService.saveActor(null);

        Assertions.assertThat(actorSaved).isEqualTo(null);
    }

    @Test
    void delete_actor_success() {
        int actorListSize = actorService.getActors().size();

        actorService.delete(actorListSize);

        int actorCurrentListSize = actorService.getActors().size();

        Assertions.assertThat(actorListSize).isGreaterThan(actorCurrentListSize);
    }



    @Test
    void updateActor_ChangeLastName_success() {

        List<Film> filmList = new ArrayList<>();

        Actor actor = new Actor(1,"Antonio","Banderas",LocalDate.now(),filmList);
        Actor actorSave = actorService.saveActor(actor);

        actorService.updateActor(actorSave.getActorId(),new Actor(1,"Antonio","Henson",LocalDate.now(),filmList));

        Assertions.assertThat(actorService.getActor(actorSave.getActorId()).getLastName()).isEqualTo("Henson");
    }

    @Test
    void updateActor_null_null() {

        Assertions.assertThat(actorService.updateActor(null,null)).isEqualTo(null);
    }

    @Test
    void updateActor_idNotExist_null() {
        List<Film> filmList = new ArrayList<>();
        Assertions.assertThat(actorService.updateActor(100000,new Actor(1,"Antonio","Banderas",LocalDate.now(),filmList))).isEqualTo(null);
    }
}