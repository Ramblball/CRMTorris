package com.example.CRMTorris.controller;

import com.example.CRMTorris.dto.OrderDto;
import com.example.CRMTorris.dto.transfer.OrderTransfer;
import com.example.CRMTorris.database.model.Order;
import com.example.CRMTorris.database.service.OrderService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{page}/")
    public ResponseEntity<List<Order>> getOrders(@PathVariable Long page) {
        return new ResponseEntity<>(
                orderService.findByIdGreaterThan(page),
                HttpStatus.OK);
    }

    @PutMapping("/order/complete/")
    public ResponseEntity<Void> completeOrder(
            @RequestHeader("Authorization") Long worker,
            @Validated(OrderTransfer.Complete.class) @RequestBody OrderDto dto) {
        dto.setWorkerId(worker);
        dto.setStatus(1);
        orderService.updateOrder(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/order/freeze/")
    public ResponseEntity<Void> freezeOrder(
            @RequestHeader("Authorization") Long worker,
            @Validated(OrderTransfer.Complete.class) @RequestBody OrderDto dto) {
        dto.setWorkerId(worker);
        dto.setStatus(2);
        orderService.updateOrder(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/order/reject/")
    public ResponseEntity<Void> rejectOrder(
            @RequestHeader("Authorization") Long worker,
            @Validated(OrderTransfer.Complete.class) @RequestBody OrderDto dto) {
        dto.setWorkerId(worker);
        dto.setStatus(3);
        orderService.updateOrder(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/order/upload/{id}/")
    public ResponseEntity<String> fileUpload(@PathVariable("id") Long id,
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

    @GetMapping("/order/download/{filename}/")
    public ResponseEntity<Resource> download(@PathVariable String filename) throws IOException {
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
