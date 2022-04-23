package com.bloodbank.demo.repository;

import com.bloodbank.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByStatus(String status);


}
