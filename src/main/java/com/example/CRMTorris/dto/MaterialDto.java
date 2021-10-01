package com.example.CRMTorris.dto;

import com.example.CRMTorris.dto.transfer.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MaterialDto extends AbstractDto{

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateTime.class, UpdateCompany.class})
    private Integer place;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateTime.class, UpdateCompany.class})
    private String material;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateTime.class, UpdateCompany.class})
    private String producer;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateTime.class, UpdateCompany.class})
    private Integer height;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateTime.class, UpdateCompany.class})
    private Integer weight;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateTime.class, UpdateCompany.class})
    private Integer thickness;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateTime.class, UpdateCompany.class})
    private Integer count;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateTime.class, UpdateCompany.class})
    private String color;

    @NotNull(groups = {New.class})
    @Null(groups = {UpdateTime.class, UpdateCompany.class})
    private Boolean owner;

    @Null
    private Date add_time;

    @NotNull(groups = {UpdateTime.class})
    @Null(groups = {New.class})
    private Date get_time;

    @NotNull(groups = {UpdateCompany.class})
    @Null(groups = {New.class})
    private Long companyId;
}
