package com.sudip.blogify.repositories;

import com.sudip.blogify.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category, Integer>{

}