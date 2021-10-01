package com.example.CRMTorris.dto;

import com.example.CRMTorris.dto.transfer.AdminDetails;
import com.example.CRMTorris.dto.transfer.Details;
import com.example.CRMTorris.dto.transfer.New;
import com.example.CRMTorris.database.model.MaterialToOrder;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderDto extends AbstractDto{

    @JsonView({Details.class})
    @Null
    private Date time;

    @JsonView({Details.class})
    @NotNull(groups = {New.class})
    private String order;

    @JsonView({Details.class})
    @NotNull(groups = {New.class})
    private String comment;
    @JsonView({Details.class})
    @NotNull(groups = {New.class})
    private Integer status;
    @JsonView({Details.class})
    private String file;

    @JsonView({Details.class})
    @Null(groups = {New.class})
    private Long workerId;

    @JsonView({Details.class})
    @NotNull(groups = {New.class})
    private Long managerId;

    @JsonView({AdminDetails.class})
    @Null(groups = {New.class})
    private Long invoiceId;

    @JsonView({Details.class})
    private Set<MaterialToOrder> materialsToOrder;
}
