package com.wagner.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wagner.demo.entities.User;
import com.wagner.demo.repositories.UsersRepository;
import com.wagner.demo.services.exceptions.ResourceNotFound;

@Service
public class UsersService {

	@Autowired
	UsersRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFound(id));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Integer id) {
		 repository.deleteById(id);
	}
	
	public User update(Integer id, User user) {
		User entity = repository.getOne(id);
		
		updateData(entity, user);
		return repository.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}

}
