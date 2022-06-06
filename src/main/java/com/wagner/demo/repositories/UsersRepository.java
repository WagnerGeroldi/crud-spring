package com.wagner.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wagner.demo.entities.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

}
