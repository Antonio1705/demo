package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Category;
import com.example.filmDbProject.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category getCategory(Integer id) {
        if (id == null){
            return null;
        }

        Optional<Category> byId = categoryRepository.findById(id);

        if (byId.isPresent()){
            return byId.get();
        }else {
            return null;
        }
    }

    public List<Category> getCategorys(){
        return (List<Category>)categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        if (category == null){
            return null;
        }
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id){
        categoryRepository.deleteById(id);
    }

    public Category updateCategory(Integer id, Category category){
        if (id == null && category == null){
            return null;
        }

        Optional<Category> categoryFindById = categoryRepository.findById(id);

        if (categoryFindById.isPresent()){
            Category categoryFindByIdGet =categoryFindById.get();
            categoryFindByIdGet.setName(category.getName());
            categoryFindByIdGet.setLastUpdate(category.getLastUpdate());
            return categoryRepository.save(categoryFindByIdGet);
        }else{
            return null;
        }
    }
}
