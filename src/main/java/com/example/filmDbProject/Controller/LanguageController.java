package com.example.filmDbProject.Controller;


import com.example.filmDbProject.Entity.Language;
import com.example.filmDbProject.Service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguage(@PathVariable Integer id){
        return new ResponseEntity<>(languageService.getLanguageById(id), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Language>> getLanguages(){
        return new ResponseEntity<>(languageService.getLanguages(), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Language> saveLanguages(@RequestBody Language language){
        return new ResponseEntity<>(languageService.saveLanguage(language), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguages(@RequestBody Language language, @PathVariable Integer id){
        return new ResponseEntity<>(languageService.updateLanguage(id,language), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLanguages(@PathVariable Integer id){
        languageService.deleteLanguage(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
