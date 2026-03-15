package org.example.supplyflow.controllers;

import org.example.supplyflow.entities.StockMovement;
import org.example.supplyflow.entities.MovementType;
import org.example.supplyflow.services.StockMovementServices;
import org.example.supplyflow.services.ProductsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/movements")
public class MovementStockController {

    private final StockMovementServices stockMovementServices;
    private final ProductsServices productsServices;

    public MovementStockController(StockMovementServices stockMovementServices, ProductsServices productsServices) {
        this.stockMovementServices = stockMovementServices;
        this.productsServices = productsServices;
    }

    @GetMapping
    public String listMovements(Model model) {
        model.addAttribute("movements", stockMovementServices.findAll());
        return "movements/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        StockMovement movement = new StockMovement();
        movement.setDate(LocalDate.now()); // Default to today
        model.addAttribute("movement", movement);
        model.addAttribute("products", productsServices.getAllProducts());
        model.addAttribute("types", MovementType.values());
        return "movements/add-movement";
    }

    @PostMapping("/save")
    public String saveMovement(@ModelAttribute("movement") StockMovement movement) {
        stockMovementServices.saveStockMovement(movement);
        return "redirect:/movements";
    }
}