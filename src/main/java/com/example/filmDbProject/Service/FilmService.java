package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Film;
import com.example.filmDbProject.Entity.FilmProjection;
import com.example.filmDbProject.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

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
}