package com.wagner.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wagner.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
