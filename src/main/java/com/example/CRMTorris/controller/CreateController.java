package com.example.CRMTorris.controller;

import com.example.CRMTorris.database.model.Order;
import com.example.CRMTorris.database.model.Worker;
import com.example.CRMTorris.database.service.OrderService;
import com.example.CRMTorris.database.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/create")
public class CreateController {

    private final WorkerService workerService;
    private final OrderService orderService;

    public CreateController(WorkerService workerService, OrderService orderService) {
        this.workerService = workerService;
        this.orderService = orderService;
    }

    @PostMapping("/worker")
    public ResponseEntity<String> addWorker(@RequestBody Worker worker) {
        if (!workerService.saveWorker(worker)) {
            return new ResponseEntity<>("Registration error", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("redirect:/", HttpStatus.CREATED);
    }

    @PostMapping("/order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        if (orderService.saveOrder(order)) {
            return new ResponseEntity<>("Registration error", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("redirect:/order", HttpStatus.CREATED);
    }
}
