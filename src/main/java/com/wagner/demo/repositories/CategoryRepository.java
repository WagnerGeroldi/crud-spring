package com.wagner.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wagner.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
