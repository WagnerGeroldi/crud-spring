package com.wagner.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wagner.demo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
