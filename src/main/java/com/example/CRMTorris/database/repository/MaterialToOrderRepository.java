package com.example.CRMTorris.database.repository;

import com.example.CRMTorris.database.model.MaterialToOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialToOrderRepository extends JpaRepository<MaterialToOrder, Long> {
}