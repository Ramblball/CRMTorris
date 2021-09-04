package com.example.CRMTorris.controller;

import com.example.CRMTorris.database.dto.OrderDto;
import com.example.CRMTorris.database.model.Order;
import com.example.CRMTorris.database.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
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

    @PostMapping("/upload")
    public ResponseEntity<String> fileUpload(@RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            OrderDto order = orderService.findById(id);
            name = order.getId() + "_" + order.getOrder();
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(name));
                stream.write(bytes);
                stream.close();
                return new ResponseEntity<>(
                        "Вы удачно загрузили " + name + " в " + name + "-uploaded !",
                        HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(
                        "Вам не удалось загрузить " + name + " => " + e.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Вам не удалось загрузить " + name + " потому что файл пустой.",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
