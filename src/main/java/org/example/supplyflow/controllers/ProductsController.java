package org.example.supplyflow.controllers;

import ch.qos.logback.core.model.Model;
import org.example.supplyflow.entities.Products;
import org.example.supplyflow.entities.Supplier;
import org.example.supplyflow.services.ProductsServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Products")
public class ProductsController {
    private final ProductsServices productsServices;

    public ProductsController(ProductsServices productsServices) {
        this.productsServices = productsServices;
    }

    @GetMapping
    public String getAllProducts(Model model){
        
    }

    @GetMapping("/{id}")
    public Products getProductByid(@PathVariable int id){
        return productsServices.getProductById(id);
    }
    @PostMapping
    public void addProduct(@RequestBody Products product){
        productsServices.saveProduct(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productsServices.deleteByIdProduct(id);
    }

}
