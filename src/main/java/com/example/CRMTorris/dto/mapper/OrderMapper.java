package com.example.CRMTorris.dto.mapper;

import com.example.CRMTorris.dto.OrderDto;
import com.example.CRMTorris.database.model.Order;
import com.example.CRMTorris.database.repository.InvoiceRepository;
import com.example.CRMTorris.database.repository.ManagerRepository;
import com.example.CRMTorris.database.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class OrderMapper extends AbstractMapper<Order, OrderDto> {

    private final WorkerRepository workerRepository;
    private final ManagerRepository managerRepository;
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public OrderMapper(WorkerRepository workerRepository, ManagerRepository managerRepository, InvoiceRepository invoiceRepository) {
        super(Order.class, OrderDto.class);
        this.workerRepository = workerRepository;
        this.managerRepository = managerRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @PostConstruct
    public void setMapper() {
        mapper.createTypeMap(Order.class, OrderDto.class)
                .addMappings(m -> {
                    m.skip(OrderDto::setWorkerId);
                    m.skip(OrderDto::setManagerId);
                    m.skip(OrderDto::setInvoiceId);
                }).setPostConverter(toDtoConverter());
        mapper.createTypeMap(OrderDto.class, Order.class)
                .addMappings(m -> {
                    m.skip(Order::setWorker);
                    m.skip(Order::setManager);
                    m.skip(Order::setInvoice);
                }).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Order source, OrderDto destination) {
        destination.setWorkerId(
                Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getWorker().getId()
        );
        destination.setManagerId(
                Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getManager().getId()
        );
        destination.setInvoiceId(
                Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getInvoice().getId()
        );
    }

    @Override
    void mapSpecificFields(OrderDto source, Order destination) {
        destination.setWorker(workerRepository.findById(source.getWorkerId()).orElse(null));
        destination.setManager(managerRepository.findById(source.getManagerId()).orElse(null));
        destination.setInvoice(invoiceRepository.findById(source.getInvoiceId()).orElse(null));
    }
}
