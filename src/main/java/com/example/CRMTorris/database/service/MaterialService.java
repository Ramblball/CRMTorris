package com.example.CRMTorris.database.service;

import com.example.CRMTorris.database.dto.MaterialDto;
import com.example.CRMTorris.database.filter.MaterialFilter;
import com.example.CRMTorris.database.dto.mapper.MaterialMapper;
import com.example.CRMTorris.database.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MaterialService {

    @PersistenceContext
    private EntityManager entityManager;
    private final MaterialMapper materialMapper;
    private final MaterialRepository materialRepository;

    public MaterialService(MaterialMapper materialMapper, MaterialRepository materialRepository) {
        this.materialMapper = materialMapper;
        this.materialRepository = materialRepository;
    }

    public Set<MaterialDto> getAll() {
        return materialRepository
                .findAll()
                .stream()
                .map(materialMapper::toDto)
                .collect(Collectors.toSet());
    }

    public Set<MaterialDto> getAllByFilter(MaterialFilter filter) {
        entityManager.createQuery("SELECT m FROM Material m WHERE " +
                "m.owner = true AND " +
                "m.material = \"material\" AND " +
                "m.color = \"color\"");
    }
}
