package com.example.CRMTorris.controller;

import com.example.CRMTorris.dto.MaterialDto;
import com.example.CRMTorris.dto.OrderDto;
import com.example.CRMTorris.dto.WorkerDto;
import com.example.CRMTorris.dto.transfer.New;
import com.example.CRMTorris.database.service.MaterialService;
import com.example.CRMTorris.database.service.OrderService;
import com.example.CRMTorris.database.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateController {

    private final MaterialService materialService;
    private final WorkerService workerService;
    private final OrderService orderService;

    public CreateController(MaterialService materialService, WorkerService workerService, OrderService orderService) {
        this.materialService = materialService;
        this.workerService = workerService;
        this.orderService = orderService;
    }

    @PostMapping("/create/worker/")
    public ResponseEntity<String> addWorker(@Validated(New.class) @RequestBody WorkerDto worker) {
        if (!workerService.saveWorker(worker)) {
            return new ResponseEntity<>("Registration error", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("redirect:/", HttpStatus.CREATED);
    }

    @PostMapping("/create/order/")
    public ResponseEntity<OrderDto> addOrder(@Validated(New.class) @RequestBody OrderDto dto) {
        return new ResponseEntity<>(orderService.save(dto), HttpStatus.CREATED);
    }

    @PostMapping("/create/material/")
    public ResponseEntity<MaterialDto> addMaterial(@Validated(New.class) @RequestBody MaterialDto dto) {
        return new ResponseEntity<>(materialService.save(dto), HttpStatus.CREATED);
    }
}
