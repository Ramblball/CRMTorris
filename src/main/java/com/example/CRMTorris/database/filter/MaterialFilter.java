package com.example.CRMTorris.database.filter;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialFilter {
    private boolean own;
    private boolean full;
    private String material;
    private String color;
    private Integer height;
    private Integer weight;
    private Integer thickness;
    private Integer place;
    private Long company;
}
