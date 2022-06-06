package com.wagner.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wagner.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
