package com.example.filmDbProject.Repository;

import com.example.filmDbProject.Entity.FilmProjection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class FilmRepositoryTest {
    @Autowired
    FilmRepository filmRepository;

    @Test
    void findByTitle_success() {
        Optional<FilmProjection> film = filmRepository.findByTitle("BabylonBerlin");

        Assertions.assertThat(film.get().getTitle()).isEqualTo("BabylonBerlin");
        Assertions.assertThat(film).isNotEmpty();
    }

    @Test
    void findByTitle_notExist_empty() {
        Optional<FilmProjection> film = filmRepository.findByTitle("Bla");


        Assertions.assertThat(film).isEmpty();
    }

    @Test
    void findByTitle_null_empty() {
        Optional<FilmProjection> film = filmRepository.findByTitle(null);


        Assertions.assertThat(film).isEmpty();
    }
}