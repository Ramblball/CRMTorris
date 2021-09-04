package com.example.CRMTorris.database.service;

import com.example.CRMTorris.database.dto.MaterialDto;
import com.example.CRMTorris.database.dto.mapper.MaterialMapper;
import com.example.CRMTorris.database.repository.MaterialRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MaterialService {

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

    public Set<MaterialDto> getAllByFilter(MaterialDto dto) {
        return materialRepository.findAll(Example.of(materialMapper.toEntity(dto)))
                .stream()
                .map(materialMapper::toDto)
                .collect(Collectors.toSet());
    }

    public MaterialDto save(MaterialDto dto) {
        dto.setAdd_time(new java.sql.Date(new Date().getTime()));
        return materialMapper.toDto(
                materialRepository.save(materialMapper.toEntity(dto)));
    }
}
