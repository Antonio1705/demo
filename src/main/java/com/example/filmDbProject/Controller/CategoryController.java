package com.example.filmDbProject.Controller;


import com.example.filmDbProject.Entity.Category;
import com.example.filmDbProject.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategorys(){
        return new ResponseEntity<>(categoryService.getCategorys(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
        return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable Integer id, @RequestBody Category category){
        return new ResponseEntity<>(categoryService.updateCategory(id,category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategoryById(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.saveCategory(category),HttpStatus.CREATED);
    }

}