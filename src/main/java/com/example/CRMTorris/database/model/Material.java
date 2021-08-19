package com.example.CRMTorris.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "material")
@Entity
@Getter
@Setter
public class Material {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "place", nullable = false)
    private Integer place;
    @Column(name = "material", nullable = false, length = 63)
    private String material;
    @Column(name = "producer", nullable = false, length = 31)
    private String producer;
    @Column(name = "height", nullable = false)
    private Integer height;
    @Column(name = "weight", nullable = false)
    private Integer weight;
    @Column(name = "thickness", nullable = false)
    private Integer thickness;
    @Column(name = "count", nullable = false)
    private Integer count;
    @Column(name = "color", nullable = false, length = 31)
    private String color;
    @Column(name = "owner", nullable = false)
    private Boolean owner = false;
    @Column(name = "add_time", nullable = false)
    private Date add_time;
    @Column(name = "get_time")
    private Date get_time;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}