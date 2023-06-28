package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Language;
import com.example.filmDbProject.Entity.LanguageProjection;
import com.example.filmDbProject.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    public LanguageProjection getLanguageById(Integer id){
        Language language =languageRepository.findById(id).get();
        return languageRepository.findLanguageByName(language.getName()).get();
    }

    public List<Language> getLanguages(){

        return (List<Language>) languageRepository.findAll();
    }

    public void deleteLanguage(Integer id){
        languageRepository.deleteById(id);
    }

    public LanguageProjection updateLanguage(Integer id, Language language){
        Language languageFindById = languageRepository.findById(id).get();

        languageFindById.setName(language.getName());
        languageFindById.setLastUpdate(language.getLastUpdate());
        languageRepository.save(languageFindById);
        LanguageProjection languageProjection = languageRepository.findLanguageByName(languageFindById.getName()).get();
        return languageProjection;
    }

    public LanguageProjection saveLanguage(Language language){
        Language languageSaved = languageRepository.save(language);
        LanguageProjection languageProjection = languageRepository.findLanguageByName(languageSaved.getName()).get();
        return languageProjection;
    }
}
