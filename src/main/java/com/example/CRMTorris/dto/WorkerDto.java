package com.example.CRMTorris.dto;

import com.example.CRMTorris.dto.transfer.New;
import com.example.CRMTorris.dto.view.View;
import com.example.CRMTorris.database.model.Role;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WorkerDto extends AbstractDto {

    @JsonView(View.Worker.class)
    @NotNull(groups = {New.class})
    private String name;

    @NotNull(groups = {New.class})
    private String password;

    @JsonView(View.Worker.class)
    private Role role;

    @JsonView(View.Worker.class)
    private List<OrderDto> orders;
}
