package com.example.CRMTorris.database.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "manager")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Manager {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "manager", length = 63)
    private String manager;
    @Column(name = "mail", length = 63)
    private String mail;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OrderBy("order.id DESC")
    @OneToMany(mappedBy = "manager", orphanRemoval = true)
    private List<Order> orders;
}