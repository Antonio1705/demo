package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Language;
import com.example.filmDbProject.Entity.LanguageProjection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class LanguageServiceTest {

    @Autowired
    LanguageService languageService;

    @Test
    void getLanguageById_languageById1_founded() {

        LanguageProjection language = languageService.getLanguageById(1);

        Assertions.assertThat(language).isNotNull();
        Assertions.assertThat(language.getName()).isNotEmpty();
    }

    @Test
    void getLanguageById_null_null() {

        LanguageProjection language = languageService.getLanguageById(null);

        Assertions.assertThat(language).isNull();
    }

    @Test
    void getLanguageById_notExist_null() {

        LanguageProjection language = languageService.getLanguageById(100000);

        Assertions.assertThat(language).isNull();
    }

    @Test
    void getLanguages_listOfLanguages_founded() {
        List<Language> languages = languageService.getLanguages();

        Assertions.assertThat(languages).isNotNull();
        Assertions.assertThat(languages.size()).isGreaterThan(2);
    }

    @Test
    void saveLanguage_createLanguageAndSave_success() {
        LanguageProjection languageSaved = languageService.getLanguageById(255);
        if (languageSaved != null){
            languageService.deleteLanguage(255);
        }

        Language language = new Language(255,"South Korean", LocalDate.now());

        languageService.saveLanguage(language);

        LanguageProjection languageGetById = languageService.getLanguageById(255);
        System.out.println(languageGetById.getName());
        Assertions.assertThat(languageGetById.getName()).isEqualTo("South Korean");
        Assertions.assertThat(languageGetById).isNotNull();
    }

    @Test
    void saveLanguage_null_null() {
        LanguageProjection languageProjection = languageService.saveLanguage(null);

        Assertions.assertThat(languageProjection).isNull();
    }

    @Test
    void deleteLanguageById_success() {
        LanguageProjection languageSaved = languageService.getLanguageById(244);
        if (languageSaved != null){
            languageService.deleteLanguage(244);
        }

        Language language = new Language(244,"Turkish", LocalDate.now());
        languageService.saveLanguage(language);

        LanguageProjection languageGetById = languageService.getLanguageById(244);

        Assertions.assertThat(languageGetById).isNotNull();
        Assertions.assertThat(languageGetById.getName()).isNotEmpty();

        languageService.deleteLanguage(244);

        LanguageProjection getDeletedLanguage = languageService.getLanguageById(244);

        Assertions.assertThat(getDeletedLanguage).isNull();
    }

    @Test
    void updateLanguage_changeName_success() {
        LanguageProjection languageById243 = languageService.getLanguageById(243);
        if (languageById243 != null){
            languageService.deleteLanguage(243);
        }

        Language language = new Language(243,"Farsi", LocalDate.now());
        languageService.saveLanguage(language);

        LanguageProjection languageGetById = languageService.getLanguageById(243);

        Assertions.assertThat(languageGetById).isNotNull();
        Assertions.assertThat(languageGetById.getName()).isEqualTo("Farsi");


        Language languageNew = new Language(243,"Croatian", LocalDate.now());
        languageService.updateLanguage(243,languageNew);


        LanguageProjection getLanguageById243 = languageService.getLanguageById(243);

        Assertions.assertThat(getLanguageById243).isNotNull();
        Assertions.assertThat(getLanguageById243.getName()).isEqualTo("Croatian");
    }

    @Test
    void updateLanguage_parameterNull_null() {

        LanguageProjection languageGetById = languageService.updateLanguage(1,null);

        Assertions.assertThat(languageGetById).isNull();
    }

    @Test
    void updateLanguage_idNotExist_null() {
        Language languageNew = new Language(222,"Nepali", LocalDate.now());
        LanguageProjection languageGetById = languageService.updateLanguage(222,languageNew);

        Assertions.assertThat(languageGetById).isNull();
    }


}