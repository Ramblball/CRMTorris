package com.example.CRMTorris.dto.mapper;

import com.example.CRMTorris.dto.MaterialDto;
import com.example.CRMTorris.database.model.Material;
import com.example.CRMTorris.database.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class MaterialMapper extends AbstractMapper<Material, MaterialDto> {

    private final CompanyRepository companyRepository;

    @Autowired
    public MaterialMapper(CompanyRepository companyRepository) {
        super(Material.class, MaterialDto.class);
        this.companyRepository = companyRepository;
    }

    @PostConstruct
    public void setMapper() {
        mapper.createTypeMap(Material.class, MaterialDto.class)
                .addMappings(m -> m.skip(MaterialDto::setCompanyId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(MaterialDto.class, Material.class)
                .addMappings(m -> m.skip(Material::setCompany)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Material source, MaterialDto destination) {
        destination.setCompanyId(
                Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getCompany().getId()
        );
    }

    @Override
    void mapSpecificFields(MaterialDto source, Material destination) {
        destination.setCompany(companyRepository.findById(source.getCompanyId()).orElse(null));
    }
}
