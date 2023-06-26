package com.example.filmDbProject.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "film_category")
public class FilmCategory {

    @EmbeddedId
    private FilmCategoryId id;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

}
