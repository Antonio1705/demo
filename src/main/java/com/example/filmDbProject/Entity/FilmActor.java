package com.example.filmDbProject.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "film_actor")
public class FilmActor {

    @EmbeddedId
    private FilmActorId id;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

}
