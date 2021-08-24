package com.example.CRMTorris.database.dto.mapper;

import com.example.CRMTorris.database.dto.CompanyDto;
import com.example.CRMTorris.database.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper extends AbstractMapper<Company, CompanyDto> {

    @Autowired
    public CompanyMapper() {
        super(Company.class, CompanyDto.class);
    }
}
