package com.example.CRMTorris.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "company")
@Entity
@Getter
@Setter
public class Company implements EntityClass{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "company", unique = true, length = 127)
    private String company;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "company_id")
    private Set<Manager> managers;

    @OrderBy("order.id DESC")
    @OneToMany(mappedBy = "company", orphanRemoval = true)
    private List<Invoice> invoices;

}