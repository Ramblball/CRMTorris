package com.example.CRMTorris.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvoiceDto extends AbstractDto {

    private Long number;
    private String producer;
    private Double cost;
    private Boolean paid;
    private Long orderId;
    private Long companyId;
}
