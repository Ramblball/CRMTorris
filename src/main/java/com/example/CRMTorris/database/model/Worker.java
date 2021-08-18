package com.example.CRMTorris.database.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "worker")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "role")
    private String role;
    @Column(name = "password", length = 31)
    private String password;

    @OrderBy("order.id DESC")
    @OneToMany(mappedBy = "worker", orphanRemoval = true)
    private List<Order> orders;

}