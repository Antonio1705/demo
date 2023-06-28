package com.example.filmDbProject.Service;

import com.example.filmDbProject.Repository.ActorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

class ActorServiceImplTest {

    @MockBean
    ActorRepository actorRepository;

    @Autowired
    ActorServiceImpl actorService;


    @Test
    void getActor_test() {




    }

    @Test
    void saveActor() {
    }

    @Test
    void delete() {
    }

    @Test
    void updateActor() {
    }
}