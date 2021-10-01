package com.example.CRMTorris.controller;

import com.example.CRMTorris.database.service.WorkerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

//    @PostMapping("/auth")
//    public ResponseEntity<Void> login(@Validated(New.class) @RequestBody WorkerDto dto) {
//        workerService.saveWorker(dto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
