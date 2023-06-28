package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Film;
import com.example.filmDbProject.Entity.FilmProjection;
import com.example.filmDbProject.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;




    public Film getFilm(int id) {

        Film film = filmRepository.findById(id).get();

        return film;
    }

    public FilmProjection getFilmProjection(int id) {

        Film film = filmRepository.findById(id).get();
        FilmProjection filmProjection = filmRepository.findByTitle(film.getTitle()).get();
        return filmProjection;
    }

    public FilmProjection getFilmByTitle(String title) {

        FilmProjection film = filmRepository.findByTitle(title).get();

        return film;
    }



    public FilmProjection saveFilm(Film film){
        Film film2 =filmRepository.save(film);
        FilmProjection filmProjection = filmRepository.findByTitle(film2.getTitle()).get();
        return filmProjection;
    }

    public Film updateFilm(int idFilm, Film film){
        Film filmFindById = filmRepository.findById(idFilm).get();
        filmFindById.setDescription(film.getDescription());
        filmFindById.setLastUpdate(film.getLastUpdate());
        filmFindById.setTitle(film.getTitle());
        filmFindById.setReleaseYear(film.getReleaseYear());

        return filmRepository.save(filmFindById);
    }

    public void deleteFilm(int idFilm){
        filmRepository.deleteById(idFilm);
    }

    public List<Film> getFilmAll() {
        return (List<Film>) filmRepository.findAll();
    }
}
