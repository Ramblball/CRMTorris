package com.example.CRMTorris.database.dto.mapper;

import com.example.CRMTorris.database.dto.AbstractDto;
import com.example.CRMTorris.database.model.EntityClass;

public interface Mapper<E extends EntityClass, D extends AbstractDto> {

    E toEntity(D dto);
    D toDto(E entity);
}
