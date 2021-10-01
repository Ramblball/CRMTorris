package com.example.CRMTorris.database.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role implements GrantedAuthority, EntityClass {
    @Id
    private Long id;

    @Column(name = "role", unique = true, nullable = false)
    private String role;

    @OneToMany(mappedBy = "role")
    private Set<Worker> workers;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}