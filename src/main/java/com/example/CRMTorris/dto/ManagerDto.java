package com.example.CRMTorris.dto;

import com.example.CRMTorris.database.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ManagerDto extends AbstractDto {

    private String manager;
    private String mail;
    private Long companyId;
    private List<Order> orders;
}
