package com.example.CRMTorris.database.repository;

import com.example.CRMTorris.database.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findTopById(Long count);
}