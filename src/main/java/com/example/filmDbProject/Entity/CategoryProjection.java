package com.example.filmDbProject.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryProjection {
    private String name;

    public CategoryProjection(Category category){
        this.name = category.getName();
    }
}
