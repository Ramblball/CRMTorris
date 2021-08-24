package com.example.CRMTorris.database.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WorkerDto extends AbstractDto {

    private String name;
    private String password;
    private Role role;
    private List<OrderDto> orders;
}
