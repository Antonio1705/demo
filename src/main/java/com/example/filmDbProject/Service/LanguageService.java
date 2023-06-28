package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Language;
import com.example.filmDbProject.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    public Language getLanguageById(Integer id){
        return languageRepository.findById(id).get();
    }

    public List<Language> getLanguages(){

        return (List<Language>) languageRepository.findAll();
    }

    public void deleteLanguage(Integer id){
        languageRepository.deleteById(id);
    }

    public Language updateLanguage(Integer id, Language language){
        Language languageFindById = languageRepository.findById(id).get();

        languageFindById.setName(language.getName());
        languageFindById.setLastUpdate(language.getLastUpdate());
        languageRepository.save(languageFindById);
        return languageFindById;
    }

    public Language saveLanguage(Language language){
        return languageRepository.save(language);
    }
}
