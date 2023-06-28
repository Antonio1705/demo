package com.example.filmDbProject.Controller;


import com.example.filmDbProject.Entity.Category;
import com.example.filmDbProject.Entity.CategoryProjection;
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
    public ResponseEntity<CategoryProjection> getCategoryById(@PathVariable Integer id){
        CategoryProjection categoryProjection = new CategoryProjection(categoryService.getCategory(id));
        return new ResponseEntity<>(categoryProjection, HttpStatus.FOUND);
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
    public ResponseEntity<CategoryProjection> saveCategoryById(@RequestBody Category category){
        CategoryProjection categoryProjection = new CategoryProjection(categoryService.saveCategory(category));
        return new ResponseEntity<>(categoryProjection,HttpStatus.CREATED);
    }

}