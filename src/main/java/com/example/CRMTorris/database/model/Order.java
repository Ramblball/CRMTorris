package com.example.CRMTorris.database.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Table(name = "order")
@Entity
@Getter
@Setter
public class Order implements EntityClass{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "time", nullable = false)
    private Date time;

    @Column(name = "order", nullable = false)
    private String order;
    @Column(name = "comment")
    private String comment;
    @Column(name = "complete")
    private boolean complete;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id", unique = true)
    private Invoice invoice;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Set<MaterialToOrder> materialsToOrder;

}