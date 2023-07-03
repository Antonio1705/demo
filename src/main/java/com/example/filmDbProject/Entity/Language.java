package com.example.filmDbProject.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "language_id")
    private Integer idLanguage;

    @Column
    private String name;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

}