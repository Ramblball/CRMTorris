package com.example.CRMTorris.dto.mapper;

import com.example.CRMTorris.dto.InvoiceDto;
import com.example.CRMTorris.database.model.Invoice;
import com.example.CRMTorris.database.repository.CompanyRepository;
import com.example.CRMTorris.database.repository.OrderRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class InvoiceMapper extends AbstractMapper<Invoice, InvoiceDto> {

    private final OrderRepository orderRepository;
    private final CompanyRepository companyRepository;

    public InvoiceMapper(OrderRepository orderRepository, CompanyRepository companyRepository) {
        super(Invoice.class, InvoiceDto.class);
        this.orderRepository = orderRepository;
        this.companyRepository = companyRepository;
    }

    @PostConstruct
    public void setMapper() {
        mapper.createTypeMap(Invoice.class, InvoiceDto.class)
                .addMappings(m -> {
                    m.skip(InvoiceDto::setOrderId);
                    m.skip(InvoiceDto::setCompanyId);
                }).setPostConverter(toDtoConverter());
        mapper.createTypeMap(InvoiceDto.class, Invoice.class)
                .addMappings(m -> {
                    m.skip(Invoice::setOrder);
                    m.skip(Invoice::setCompany);
                }).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Invoice source, InvoiceDto destination) {
        destination.setOrderId(
                Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getOrder().getId()
        );
        destination.setCompanyId(
                Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getCompany().getId()
        );
    }

    @Override
    void mapSpecificFields(InvoiceDto source, Invoice destination) {
        destination.setOrder(orderRepository.findById(source.getOrderId()).orElse(null));
        destination.setCompany(companyRepository.findById(source.getCompanyId()).orElse(null));
    }
}
