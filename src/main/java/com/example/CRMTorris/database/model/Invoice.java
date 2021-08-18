package com.example.CRMTorris.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "invoice")
@Entity
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", unique = true)
    private Long number;
    @Column(name = "producer", length = 31)
    private String producer;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "paid")
    private Boolean paid;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false, unique = true)
    private Company company;

}