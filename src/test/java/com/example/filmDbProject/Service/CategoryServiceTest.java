package com.example.filmDbProject.Service;


import com.example.filmDbProject.Entity.Category;
import com.example.filmDbProject.Entity.Film;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CategoryServiceTest {
    @Autowired
    CategoryService categoryService;


    @Test
    void getCategory_byId_success() {

        Category category = categoryService.getCategory(1);
        Assertions.assertThat(category).isNotNull();
        Assertions.assertThat(category.getName()).isNotEmpty();
    }

    @Test
    void getCategory_byIdNull_Null() {

        Category category = categoryService.getCategory(null);
        Assertions.assertThat(category).isNull();
    }


    @Test
    void getCategory_notExist_null() {

        Assertions.assertThat(categoryService.getCategory(10000)).isNull();
    }

    @Test
    void getCategorys_listOfCategorys() {

        List<Category> categorys = categoryService.getCategorys();

        Assertions.assertThat(categorys).isInstanceOf(ArrayList.class);
        Assertions.assertThat(categorys.size()).isGreaterThan(1);
    }

    @Test
    void saveCategory_newCategory_saved() {
        List<Film> filmList = new ArrayList<>();
        Category categorySaved =categoryService.saveCategory(new Category(2,"Horor-Comedy", LocalDate.now(),filmList));
        Assertions.assertThat(categorySaved.getName()).isEqualTo(categoryService.getCategory(categorySaved.getCategoryId()).getName());
    }

    @Test
    void saveCategory_newCategoryWithNullValue_saved() {
        List<Film> filmList = new ArrayList<>();
        Category categorySaved =categoryService.saveCategory(new Category(200,"Horor-Comedy", null,null));
        Assertions.assertThat(categorySaved.getName()).isEqualTo(categoryService.getCategory(categorySaved.getCategoryId()).getName());
        categoryService.deleteCategory(200);
    }

    @Test
    void saveCategory_null_null() {
        List<Film> filmList = new ArrayList<>();
        Category categorySaved =categoryService.saveCategory(null);
        Assertions.assertThat(categorySaved).isNull();
    }

    @Test
    void updateCategory_success() {
        List<Film> filmList = new ArrayList<>();

        categoryService.saveCategory(new Category(222,"Horor-Comedy", LocalDate.now(),filmList));
        Assertions.assertThat(categoryService.getCategory(222).getName()).isEqualTo("Horor-Comedy");

        categoryService.updateCategory(222,new Category(222,"Horor", LocalDate.now(),filmList));
        Assertions.assertThat(categoryService.getCategory(222).getName()).isEqualTo("Horor");
        categoryService.deleteCategory(222);
    }

    @Test
    void updateCategory_idNullAndCategory_null() {
        List<Film> filmList = new ArrayList<>();

        categoryService.saveCategory(new Category(2,"Horor-Comedy", LocalDate.now(),filmList));
        Assertions.assertThat(categoryService.getCategory(2).getName()).isEqualTo("Horor-Comedy");


        Assertions.assertThat(categoryService.updateCategory(null,null)).isNull();
    }

    @Test
    void updateCategory_idNotExist_Null() {
        List<Film> filmList = new ArrayList<>();

        categoryService.saveCategory(new Category(2,"Horor-Comedy", LocalDate.now(),filmList));
        Assertions.assertThat(categoryService.getCategory(2).getName()).isEqualTo("Horor-Comedy");


        Assertions.assertThat(categoryService.updateCategory(10000,new Category(10000,"Horor-Comedy", LocalDate.now(),filmList))).isNull();
    }

    @Test
    void deleteCategory_createNewCategoryAndDelete_success() {
        // I have the ability to remove a category, but only if it is not being utilized as a foreign key in any other table.
        Category category = categoryService.getCategory(200);
        if (category != null){
            categoryService.deleteCategory(200);
        }

        List<Film> filmList = new ArrayList<>();

        categoryService.saveCategory(new Category(200,"France-Movies", LocalDate.now(),filmList));

        categoryService.deleteCategory(200);
        Assertions.assertThat(categoryService.getCategory(200)).isNull();
    }

}