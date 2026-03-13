package org.example.supplyflow.repositories;

import org.example.supplyflow.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepos extends JpaRepository<Supplier, Integer> {
}
