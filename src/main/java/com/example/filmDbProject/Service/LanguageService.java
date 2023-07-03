package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Language;
import com.example.filmDbProject.Entity.LanguageProjection;
import com.example.filmDbProject.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    public LanguageProjection getLanguageById(Integer id){
        if (id == null){
            return null;
        }

        Optional<Language> language =languageRepository.findById(id);
        if (language.isPresent()){
            Language languageGet = language.get();
            return languageRepository.findLanguageByName(languageGet.getName()).get();
        }
        return null;
    }

    public List<Language> getLanguages(){
        return (List<Language>) languageRepository.findAll();
    }

    public void deleteLanguage(Integer id){
        languageRepository.deleteById(id);
    }

    public LanguageProjection updateLanguage(Integer id, Language language){
        if (id == null || language == null ){
            return null;
        }

        Optional<Language> languageFindById = languageRepository.findById(id);

        if (languageFindById.isPresent()){
            Language languageGet = languageFindById.get();
            languageGet.setName(language.getName());
            languageGet.setLastUpdate(language.getLastUpdate());
            languageRepository.save(languageGet);

            LanguageProjection languageProjection = languageRepository.findLanguageByName(languageGet.getName()).get();

            return languageProjection;
        }
        return null;
    }

    public LanguageProjection saveLanguage(Language language){
        if (language == null){
            return null;
        }

        Language languageSaved = languageRepository.save(language);
        LanguageProjection languageProjection = languageRepository.findLanguageByName(languageSaved.getName()).get();

        return languageProjection;
    }
}