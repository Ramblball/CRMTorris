package com.example.CRMTorris.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "material_to_order")
@Entity
@Getter
@Setter
public class MaterialToOrder implements EntityClass {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "count", nullable = false)
    private Integer count;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @OneToOne(optional = false)
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

}