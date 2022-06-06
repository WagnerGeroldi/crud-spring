package com.wagner.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wagner.demo.entities.User;
import com.wagner.demo.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

}
