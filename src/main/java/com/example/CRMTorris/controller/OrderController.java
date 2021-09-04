package com.example.CRMTorris.controller;

import com.example.CRMTorris.database.model.Order;
import com.example.CRMTorris.database.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{page}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable("page") Long page) {
        return new ResponseEntity<>(
                orderService.findByIdGreaterThan(page),
                HttpStatus.OK);
    }

    @PutMapping("/complete/{order}")
    public ResponseEntity<String> completeOrder(@CookieValue("id") Long worker, @PathVariable("order") Long order) {
        if (orderService.isComplete(order)) {
            return new ResponseEntity<>("Order has been completed already", HttpStatus.BAD_REQUEST);
        }
        orderService.completeOrder(order, worker);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
