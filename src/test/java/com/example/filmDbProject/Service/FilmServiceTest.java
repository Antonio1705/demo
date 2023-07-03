package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FilmServiceTest {

    @Autowired
    FilmService filmService;

    @Test
    void getFilm_byId_success() {
        Film film =filmService.getFilm(1);

        Assertions.assertThat(film).isNotNull();
        Assertions.assertThat(film.getTitle()).isNotEmpty();
    }

    @Test
    void getFilm_byIdNotExist_null() {
        Film film =filmService.getFilm(100000);

        Assertions.assertThat(film).isNull();
    }

    @Test
    void getFilm_byIdNotNull_null() {
        Assertions.assertThat(filmService.getFilm(null)).isNull();
    }


    @Test
    void getFilmProjection_byiD_success() {

        FilmProjection filmProjection = filmService.getFilmProjection(1);

        Assertions.assertThat(filmProjection).isNotNull();
        Assertions.assertThat(filmProjection.getTitle()).isNotEmpty();
    }

    @Test
    void getFilmProjection_idNotExist_null() {

        FilmProjection filmProjection = filmService.getFilmProjection(10000);
        Assertions.assertThat(filmProjection).isNull();
    }

    @Test
    void getFilmProjection_idNull_null() {
        FilmProjection filmProjection = filmService.getFilmProjection(null);

        Assertions.assertThat(filmProjection).isNull();
    }

    @Test
    void getFilmByTitle_filmCreateAndFind_success() {
        FilmProjection filmProjection =filmService.getFilmByTitle("BabylonBerlin");

        Assertions.assertThat(filmProjection).isNotNull();
        Assertions.assertThat(filmProjection.getTitle()).isNotEmpty();
    }

    @Test
    void getFilmByTitle_notExist_null() {
        FilmProjection filmProjection =filmService.getFilmByTitle("Titanic");

        Assertions.assertThat(filmProjection).isNull();
    }

    @Test
    void getFilmTitle_null_null() {
        FilmProjection filmProjection =filmService.getFilmByTitle(null);

        Assertions.assertThat(filmProjection).isNull();
    }

    @Test
    void saveFilm_film_success() {
        Film filmGetById = filmService.getFilm(1500);

        if (filmGetById != null){
            filmService.deleteFilm(1500);
        }

        List<Actor> actors = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();

        Film film = new Film(1500,"Black List",null,null,1,3,4,4,2,"A",
                LocalDate.now(),actors,new Language(6,"Roman",LocalDate.now()),categoryList);


        Assertions.assertThat(filmService.saveFilm(film)).isNotNull();
        filmService.deleteFilm(1500);
    }

    @Test
    void saveFilm_filmNull_null() {

        Assertions.assertThat(filmService.saveFilm(null)).isNull();
    }

    @Test
    void updateFilm_createFilmAndUpdate_success() {
        Film filmGetById = filmService.getFilm(1510);

        if (filmGetById != null){
            filmService.deleteFilm(1510);
        }

        List<Actor> actors = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        Film film = new Film(1510,"TomAndJarry",null,null,1,3,4,4,2,"A",
                LocalDate.now(),actors,new Language(6,"Roman",LocalDate.now()),categoryList);
        FilmProjection savedFilm = filmService.saveFilm(film);

        Assertions.assertThat(filmService.getFilm(1510).getTitle()).isEqualTo("TomAndJarry");

        Film filmNew = new Film(1511,"Tom and Jarry",null,null,1,3,4,4,2,"A",
                LocalDate.now(),actors,new Language(6,"Roman",LocalDate.now()),categoryList);
        filmService.updateFilm(1510,filmNew);
        Assertions.assertThat(filmService.getFilm(1510).getTitle()).isEqualTo("Tom and Jarry");
        filmService.deleteFilm(1510);
    }

    @Test
    void updateFilm_idNotExist_null() {
        List<Actor> actors = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        Film film = new Film(100000,"TomAndJarry",null,null,1,3,4,4,2,
                "A", LocalDate.now(),actors,new Language(6,"Roman",LocalDate.now()),categoryList);

        Film filmUpdated = filmService.updateFilm(10000000,film);
        Assertions.assertThat(filmUpdated).isNull();
    }

    @Test
    void updateFilm_idNull_null() {

        List<Actor> actors = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        Film film = new Film(100000,"TomAndJarry",null,null,1,3,4,4,2,"A",
                LocalDate.now(),actors,new Language(6,"Roman",LocalDate.now()),categoryList);

        Film filmUpdated = filmService.updateFilm(null,film);
        Assertions.assertThat(filmUpdated).isNull();
    }

    ///////////
    @Test
    void deleteFilm_createFilmAndDelete_success() {
        Film filmGetById = filmService.getFilm(1302);

        if (filmGetById != null){
            filmService.deleteFilm(1302);
        }

        List<Actor> actors = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        Film film = new Film(1302,"Copernicus",null,null,1,3,4,4,2,"A", LocalDate.now(),actors,new Language(6,"Roman",LocalDate.now()),categoryList);

        FilmProjection filmSave = filmService.saveFilm(film);

        FilmProjection filmProjection = filmService.getFilmProjection(1302);

        Assertions.assertThat(filmProjection.getTitle()).isEqualTo("Copernicus");

        filmService.deleteFilm(1302);

        FilmProjection getDeletedFilm = filmService.getFilmProjection(1302);

        Assertions.assertThat(getDeletedFilm).isNull();
    }

    @Test
    void getFilmAll_listOfFilms_success() {
        List<Film> filmList = filmService.getFilmAll();

        Assertions.assertThat(filmList).isNotEmpty();
        Assertions.assertThat(filmList).isNotNull();
        Assertions.assertThat(filmList.size()).isGreaterThan(1);

    }
}