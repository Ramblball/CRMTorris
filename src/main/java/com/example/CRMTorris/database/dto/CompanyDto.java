package com.example.CRMTorris.database.dto;

import com.example.CRMTorris.database.model.Invoice;
import com.example.CRMTorris.database.model.Manager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CompanyDto extends AbstractDto {

    private String company;
    private Set<Manager> managers;
    private List<Invoice> invoices;
}
