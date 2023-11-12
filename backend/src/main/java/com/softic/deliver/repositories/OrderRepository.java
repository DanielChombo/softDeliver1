package com.softic.deliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softic.deliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
