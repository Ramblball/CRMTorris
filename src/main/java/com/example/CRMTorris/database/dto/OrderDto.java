package com.example.CRMTorris.database.dto;

import com.example.CRMTorris.database.model.MaterialToOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderDto extends AbstractDto{
    private Date time;
    private String order;
    private String comment;
    private Long workerId;
    private Long managerId;
    private Long invoiceId;
    private Set<MaterialToOrder> materialsToOrder;
}
