package com.example.CRMTorris.database.service;

import com.example.CRMTorris.database.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class Material {

    @PersistenceContext
    private EntityManager entityManager;
    private final MaterialRepository materialRepository;


    public Material(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }
}
