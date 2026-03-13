package org.example.supplyflow.repositories;

import org.example.supplyflow.entities.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMovementRepos extends JpaRepository<StockMovement, Integer> {

}
