package com.example.CRMTorris.controller;

import com.example.CRMTorris.database.model.Order;
import com.example.CRMTorris.database.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getOrders(@PathVariable Long page) {
        return new ResponseEntity<>(
                orderService.findByIdGreaterThan(page),
                HttpStatus.OK);
    }
}
