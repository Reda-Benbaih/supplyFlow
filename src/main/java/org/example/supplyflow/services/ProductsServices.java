package org.example.supplyflow.services;

import org.example.supplyflow.entities.Products;
import org.example.supplyflow.repositories.ProductsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServices {
    private final ProductsRepos productsRepos ;

    public ProductsServices(ProductsRepos productsRepos){
        this.productsRepos = productsRepos;
    }

    public List<Products> getAllProducts(){
        return productsRepos.findAll();
    }

    public Products getProductById(int id){
        return productsRepos.findById(id).orElse(null);
    }

    public void saveProduct(Products product){
        productsRepos.save(product);
    }
    public void deleteByIdProduct(int id){
        productsRepos.deleteById(id);
    }


}
