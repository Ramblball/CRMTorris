package com.example.CRMTorris.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "invoice")
@Entity
@Getter
@Setter
public class Invoice implements EntityClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false)
    private Long number;
    @Column(name = "producer", nullable = false)
    private String producer;
    @Column(name = "cost", nullable = false)
    private Double cost;
    @Column(name = "paid", nullable = false)
    private Boolean paid = false;

    @OneToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id")
    private Company company;

}