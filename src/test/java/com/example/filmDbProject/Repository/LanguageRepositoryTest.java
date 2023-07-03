package com.example.filmDbProject.Repository;

import com.example.filmDbProject.Entity.LanguageProjection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class LanguageRepositoryTest {

    @Autowired
    LanguageRepository languageRepository;

    @Test
    void findLanguageByName_success() {
        Optional<LanguageProjection> language =languageRepository.findLanguageByName("English");

        Assertions.assertThat(language.get().getName()).isEqualTo("English");
    }

    @Test
    void findLanguageByName_notExist_empty() {
        Optional<LanguageProjection> language =languageRepository.findLanguageByName("Bla");

        Assertions.assertThat(language).isEmpty();
    }

    @Test
    void findLanguageByName_null_empty() {
        Optional<LanguageProjection> language =languageRepository.findLanguageByName(null);

        Assertions.assertThat(language).isEmpty();
    }
}