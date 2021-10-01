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
public class Manager implements EntityClass {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manager", nullable = false)
    private String manager;
    @Column(name = "mail", nullable = false)
    private String mail;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OrderBy("order.id DESC")
    @OneToMany(mappedBy = "manager")
    private List<Order> orders;
}