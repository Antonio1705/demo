package com.example.demo.Repository;

import com.example.demo.Entity.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
