package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Actor;
import com.example.filmDbProject.Entity.Category;
import com.example.filmDbProject.Entity.Film;
import com.example.filmDbProject.Entity.FilmProjection;
import com.example.filmDbProject.Repository.ActorRepository;
import com.example.filmDbProject.Repository.CategoryRepository;
import com.example.filmDbProject.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    CategoryRepository categoryRepository;
    public Film getFilm(Integer id) {
        if (id == null){
            return null;
        }

        Optional<Film> film = filmRepository.findById(id);

        if (film.isPresent()){
            Film filmGet = film.get();
            return filmGet;
        }
        return null;
    }

    public FilmProjection getFilmProjection(Integer id) {
        if (id == null){
            return null;
        }

        Optional<Film> film = filmRepository.findById(id);

        if (film.isPresent()){
            FilmProjection filmProjection = filmRepository.findByTitle(film.get().getTitle()).get();
            return filmProjection;
        }
        return null;
    }

    public FilmProjection getFilmByTitle(String title) {
        if (title == null){
            return null;
        }

        Optional<FilmProjection> film = filmRepository.findByTitle(title);

        if (film.isPresent()){
            FilmProjection filmGet = film.get();
            return filmGet;
        }
        return null;
    }

    public FilmProjection saveFilm(Film film){
        if (film == null){
            return null;
        }

        Film film2 =filmRepository.save(film);
        System.out.println(film2.getFilmId() + "savedFilm");
        FilmProjection filmProjection = filmRepository.findByTitle(film2.getTitle()).get();

        return filmProjection;
    }

    public Film updateFilm(Integer idFilm, Film film){
        if (film == null || idFilm == null){
            return null;
        }

        Optional<Film> filmFindById = filmRepository.findById(idFilm);

        if (filmFindById.isPresent()){
            Film filmGet = filmFindById.get();
            filmGet.setDescription(film.getDescription());
            filmGet.setLastUpdate(film.getLastUpdate());
            filmGet.setTitle(film.getTitle());
            filmGet.setReleaseYear(film.getReleaseYear());

            return filmRepository.save(filmGet);
        }
        return null;
    }

    public void deleteFilm(int idFilm){
        filmRepository.deleteById(idFilm);
    }

    public List<Film> getFilmAll() {
        return (List<Film>) filmRepository.findAll();
    }

    public Film addCategory(Integer id, String category) {
        Category category1 = categoryRepository.findByName(category);
        Film film;
        Optional<Film> findFilm = filmRepository.findById(id);

        if (findFilm.isPresent()){
            film =findFilm.get();
            film.getCategoryList().add(category1);
            filmRepository.save(film);
            return film;
        }
        return null;
    }


    public Film addActorToFilmFindedById(Integer id,String actorFirstName, String actorLastName){
        Optional<Film> film = filmRepository.findById(id);
        Optional<Actor> actor = actorRepository.findActorByFirstNameAndLastName(actorFirstName,actorLastName);
        if (film.isPresent() && actor.isPresent()){
            Film filmGet = film.get();
            Actor actorGet = actor.get();
            System.out.println(actorGet.getFirstName());
            filmGet.getActorList().add(actorGet);
            filmRepository.save(filmGet);
            return filmGet;

        }
        return null;
    }

    public List<Category> getFilmCategorys(Integer filmId){
        Optional<Film> findFilm = filmRepository.findById(filmId);

        if (findFilm.isPresent()){
            Film film = findFilm.get();
            return film.getCategoryList();
        }
        return null;
    }

    /* Das hier geht nicht weil film find By Title ist eine projection
    public Film addActorToFilmFindedByName(String title,String actorFirstName, String actorLastName){
        Optional<FilmProjection> film = filmRepository.findByTitle(title);
        Optional<Actor> actor = actorRepository.findActorByFirstNameAndLastName(actorFirstName,actorLastName);
        if (film.isPresent() && actor.isPresent()){
            FilmProjection filmGet = film.get();
            Actor actorGet = actor.get();
            filmGet.getActorList().add(actorGet);
            return filmGet;

        }

        return null;
    }*/
}