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
public class Role implements GrantedAuthority {
    @Id
    private Long id;

    @Column(name = "role", unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<Worker> users;

    @Override
    public String getAuthority() {
        return role;
    }
}