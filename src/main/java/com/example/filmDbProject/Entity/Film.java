package com.example.filmDbProject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    private int filmId;

    private String title;

    private String description;

    @Column(name = "release_year")
    private String releaseYear;

    @Column(name = "language_id")
    private Integer languageId;

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

}
