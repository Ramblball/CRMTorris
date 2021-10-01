package com.example.CRMTorris.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "material")
@Entity
@Getter
@Setter
public class Material implements EntityClass{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place", nullable = false)
    private Integer place;
    @Column(name = "material", nullable = false)
    private String material;
    @Column(name = "full", nullable = false)
    private Boolean full;
    @Column(name = "height", nullable = false)
    private Integer height;
    @Column(name = "weight", nullable = false)
    private Integer weight;
    @Column(name = "thickness", nullable = false)
    private Integer thickness;
    @Column(name = "count", nullable = false)
    private Integer count;
    @Column(name = "color", nullable = false)
    private String color;
    @Column(name = "add_time", nullable = false)
    private Date add_time;
    @Column(name = "used")
    private Boolean used;
    @Column(name = "part_of")
    private Long partOf;
    @Column(name = "get_time")
    private Date get_time;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}