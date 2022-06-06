package com.wagner.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wagner.demo.entities.Category;
import com.wagner.demo.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
