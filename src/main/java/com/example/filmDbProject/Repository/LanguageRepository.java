package com.example.filmDbProject.Repository;

import com.example.filmDbProject.Entity.Language;
import com.example.filmDbProject.Entity.LanguageProjection;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LanguageRepository extends CrudRepository<Language,Integer> {

    Optional<LanguageProjection> findLanguageByName(String name);
}
