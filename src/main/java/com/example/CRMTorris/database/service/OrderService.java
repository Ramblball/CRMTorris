package com.example.CRMTorris.database.service;

import com.example.CRMTorris.dto.OrderDto;
import com.example.CRMTorris.dto.mapper.OrderMapper;
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
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    public OrderDto save(OrderDto dto) {
        return orderMapper.toDto(orderRepository.save(orderMapper.toEntity(dto)));
    }

    public OrderDto findById(Long id) {
        return orderMapper.toDto(orderRepository.getById(id));
    }

    public void updateOrder(OrderDto dto) {
        orderRepository.save(orderMapper.toEntity(dto));
    }

    public List<Order> findByIdGreaterThan(Long page) {
        return orderRepository.findTopById(page * 20);
    }
}
