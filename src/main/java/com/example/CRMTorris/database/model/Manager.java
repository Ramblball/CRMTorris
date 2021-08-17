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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "manager", length = 63)
    private String manager;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OrderBy("order.id DESC")
    @OneToMany(mappedBy = "manager", orphanRemoval = true)
    private List<Order> orders;

}