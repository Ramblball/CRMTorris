package com.example.CRMTorris.database.repository;

import com.example.CRMTorris.database.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}