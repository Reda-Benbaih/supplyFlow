package org.example.supplyflow.services;

import org.example.supplyflow.entities.StockMovement;
import org.example.supplyflow.repositories.StockMovementRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMovementServices {
    private final StockMovementRepos stockMovementRepos;

    public StockMovementServices(StockMovementRepos stockMovementRepos) {
        this.stockMovementRepos = stockMovementRepos;
    }

    public StockMovement findById(int id){
        return stockMovementRepos.findById(id).orElse(null);
    }
    public List<StockMovement> findAll(){
        return stockMovementRepos.findAll();
    }
    public void saveStockMovement(StockMovement stockMovement){
        stockMovementRepos.save(stockMovement);
    }
    public void deleteStockMovement(int id){
        stockMovementRepos.deleteById(id);
    }

}
