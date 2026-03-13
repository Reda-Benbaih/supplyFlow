package org.example.supplyflow.repositories;

import org.example.supplyflow.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepos extends JpaRepository<Products, Integer> {
}
