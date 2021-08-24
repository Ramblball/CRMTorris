package com.example.CRMTorris.database.dto;

import com.example.CRMTorris.database.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MaterialDto extends AbstractDto{

    private Integer place;
    private String material;
    private String producer;
    private Integer height;
    private Integer weight;
    private Integer thickness;
    private Integer count;
    private String color;
    private Boolean owner;
    private Date add_time;
    private Date get_time;
    private Long companyId;
}
