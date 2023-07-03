package com.example.filmDbProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    @Column(name = "film_id")
    private int filmId;

    private String title;

    private String description;

    @Column(name = "release_year")
    private String releaseYear;

    @Column(name = "original_language_id")
    private Integer originalLanguageId;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private double rentalRate;

    private int length;

    @Column(name = "replacement_cost")
    private double replacementCost;

    private String rating;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

    @JsonIgnore
    @ManyToMany(mappedBy = "filmList")
    List<Actor> actorList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categoryList;
}