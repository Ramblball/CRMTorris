package com.example.CRMTorris.controller;

import com.example.CRMTorris.database.dto.MaterialDto;
import com.example.CRMTorris.database.dto.OrderDto;
import com.example.CRMTorris.database.dto.transfer.Details;
import com.example.CRMTorris.database.dto.transfer.New;
import com.example.CRMTorris.database.model.Order;
import com.example.CRMTorris.database.model.Worker;
import com.example.CRMTorris.database.service.MaterialService;
import com.example.CRMTorris.database.service.OrderService;
import com.example.CRMTorris.database.service.WorkerService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/create")
public class CreateController {

    private final MaterialService materialService;
    private final WorkerService workerService;
    private final OrderService orderService;

    public CreateController(MaterialService materialService, WorkerService workerService, OrderService orderService) {
        this.materialService = materialService;
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

//    @PostMapping("/order")
//    public ResponseEntity<Order> addOrder(@Validated(New.class) @RequestBody OrderDto dto) {
//        if (orderService.save(order)) {
//            return new ResponseEntity<>("Registration error", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>("redirect:/order", HttpStatus.CREATED);
//    }

    @PostMapping("/material")
    public ResponseEntity<MaterialDto> addMaterial(@Validated(New.class) @RequestBody MaterialDto dto) {
        return new ResponseEntity<>(materialService.save(dto), HttpStatus.CREATED);
    }
}
