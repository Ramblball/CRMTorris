package com.example.CRMTorris.database.repository;

import com.example.CRMTorris.database.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Optional<Worker> findByIdEquals(Long id);

    Optional<Worker> findByNameEquals(String name);
}