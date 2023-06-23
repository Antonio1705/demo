package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category getCategory(Integer id) {
        return categoryRepository.findById(id).get();
    }

    public List<Category> getCategorys(){
        return (List<Category>)categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id){
        categoryRepository.deleteById(id);
    }

    public Category updateCategory(Integer id, Category category){
        Category categoryFindById = categoryRepository.findById(id).get();

        categoryFindById.setName(category.getName());
        categoryFindById.setLastUpdate(category.getLastUpdate());
        return categoryRepository.save(categoryFindById);
    }

}
