package org.example.supplyflow.controllers;

import org.example.supplyflow.entities.Products;
import org.example.supplyflow.services.ProductsServices;
import org.example.supplyflow.services.SupplierServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductsServices productsServices;
    private final SupplierServices supplierServices;

    public ProductsController(ProductsServices productsServices, SupplierServices supplierServices) {
        this.productsServices = productsServices;
        this.supplierServices = supplierServices;
    }

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productsServices.getAllProducts());
        return "products/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Products());
        model.addAttribute("suppliers", supplierServices.findAllSuppliers());
        return "products/add-product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Products product) {
        productsServices.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productsServices.deleteByIdProduct(id);
        return "redirect:/products";
    }
}