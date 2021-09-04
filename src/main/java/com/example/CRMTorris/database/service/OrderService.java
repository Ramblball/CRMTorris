package com.example.CRMTorris.database.service;

import com.example.CRMTorris.database.dto.OrderDto;
import com.example.CRMTorris.database.dto.mapper.OrderMapper;
import com.example.CRMTorris.database.model.Order;
import com.example.CRMTorris.database.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    public OrderDto getOrderById(Long id) {
        return orderRepository.findById(id).map(orderMapper::toDto).orElse(null);
    }

    public OrderDto saveOrder(OrderDto dto) {
        Order order = orderMapper.toEntity(dto);
        return orderMapper.toDto(orderRepository.save(order));
    }

    public void completeOrder(Long id, Long worker) {
        OrderDto dto = getOrderById(id);
        if (!Objects.isNull(dto)) {
            dto.setComplete(true);
            dto.setWorkerId(worker);
            saveOrder(dto);
        }
    }

    public boolean isComplete(Long id) {
        return orderRepository.findById(id).map(Order::isComplete).orElse(false);
    }

    public List<Order> findByIdGreaterThan(Long page) {
        return orderRepository.findTopById(page * 20);
    }
}
