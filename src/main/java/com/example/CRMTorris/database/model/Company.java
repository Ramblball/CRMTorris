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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company", unique = true)
    private String company;

    @OneToMany(mappedBy = "company")
    private Set<Manager> managers;

    @OrderBy("order.id DESC")
    @OneToMany(mappedBy = "company")
    private List<Invoice> invoices;
}