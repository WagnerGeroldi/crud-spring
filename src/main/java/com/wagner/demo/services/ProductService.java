package com.wagner.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wagner.demo.entities.Product;
import com.wagner.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Integer id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
