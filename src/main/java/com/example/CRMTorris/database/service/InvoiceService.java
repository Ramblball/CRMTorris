package com.example.CRMTorris.database.service;

import com.example.CRMTorris.database.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class InvoiceService {

    @PersistenceContext
    private EntityManager entityManager;
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
}
