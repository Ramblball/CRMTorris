package com.example.CRMTorris.database.dto.mapper;

import com.example.CRMTorris.database.dto.ManagerDto;
import com.example.CRMTorris.database.model.Manager;
import com.example.CRMTorris.database.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class ManagerMapper extends AbstractMapper<Manager, ManagerDto> {

    private final CompanyRepository companyRepository;

    @Autowired
    public ManagerMapper(CompanyRepository companyRepository) {
        super(Manager.class, ManagerDto.class);
        this.companyRepository = companyRepository;
    }

    @Override
    public Manager toEntity(ManagerDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Manager.class);
    }

    @Override
    public ManagerDto toDto(Manager entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ManagerDto.class);
    }

    @PostConstruct
    public void setMapper() {
        mapper.createTypeMap(Manager.class, ManagerDto.class)
                .addMappings(m -> m.skip(ManagerDto::setCompanyId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ManagerDto.class, Manager.class)
                .addMappings(m -> m.skip(Manager::setCompany)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Manager source, ManagerDto destination) {
        destination.setCompanyId(
                Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getCompany().getId()
        );
    }

    @Override
    void mapSpecificFields(ManagerDto source, Manager destination) {
        destination.setCompany(companyRepository.findById(source.getCompanyId()).orElse(null));
    }
}
