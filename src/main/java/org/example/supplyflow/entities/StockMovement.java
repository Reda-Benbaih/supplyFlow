package org.example.supplyflow.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "stockMovement")
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private MovementType type;

    private LocalDate date;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Products products;

    public StockMovement() {
    }

    public StockMovement(MovementType type, LocalDate date, int quantity, Products products) {
        this.type = type;
        this.date = date;
        this.quantity = quantity;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
