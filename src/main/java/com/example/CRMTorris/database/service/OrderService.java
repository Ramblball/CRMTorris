package com.example.CRMTorris.database.service;

import com.example.CRMTorris.database.model.Order;
import com.example.CRMTorris.database.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class OrderService {

    @PersistenceContext
    private EntityManager entityManager;
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findByIdGreaterThan(Long page) {
        return orderRepository.findTopById(page * 20);
    }
}
