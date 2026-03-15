package org.example.supplyflow.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    @OneToMany(mappedBy = "products")
//    @JoinColumn(name = "stockMouvementId")
    private List<StockMovement> stockMovement;


    public Products(){}

    public Products(String name, String category, BigDecimal price, int quantity, Supplier supplier) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<StockMovement> getStockMovement() {
        return stockMovement;
    }

    public void setStockMovement(List<StockMovement> stockMovement) {
        this.stockMovement = stockMovement;
    }
}
