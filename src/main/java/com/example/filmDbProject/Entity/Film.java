package com.example.filmDbProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "film")
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer filmId ;

    private String title;

    private String description;

    @Column(name = "release_year")
    private String releaseYear;

    @Column(name = "original_language_id")
    private Integer originalLanguageId = 1;

    @Column(name = "rental_duration")
    private Integer rentalDuration = 2;

    @Column(name = "rental_rate")
    private double rentalRate = 2.2;

    private int length = 2;

    @Column(name = "replacement_cost")
    private double replacementCost = 4.4;

    private String rating = "2";

    @Column(name = "last_update")
    private String lastUpdate = "2222";

    @JsonIgnore
    @ManyToMany(mappedBy = "filmList")
    List<Actor> actorList = new ArrayList<>();

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language = new Language(1,"english","2222");

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categoryList = new ArrayList<>();
}



