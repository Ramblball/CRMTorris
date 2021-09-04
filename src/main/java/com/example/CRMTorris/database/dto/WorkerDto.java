package com.example.CRMTorris.database.dto;

import com.example.CRMTorris.database.dto.view.View;
import com.fasterxml.jackson.annotation.JsonView;
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

    @JsonView(View.Worker.class)
    private String name;

    @JsonView(View.Admin.class)
    private String password;

    @JsonView(View.Worker.class)
    private Role role;

    @JsonView(View.Worker.class)
    private List<OrderDto> orders;
}
