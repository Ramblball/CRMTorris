package com.example.CRMTorris.database.service;

import com.example.CRMTorris.database.model.Worker;
import com.example.CRMTorris.database.repository.WorkerRepository;
import com.example.CRMTorris.exception.database.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker findById(Long id) {
        return workerRepository
                .findByIdEquals(id)
                .orElseThrow(() -> new NotFoundException(String.format("User %d not found", id)));
    }
}
