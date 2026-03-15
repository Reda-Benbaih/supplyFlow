package org.example.supplyflow.controllers;

import org.example.supplyflow.entities.Supplier;
import org.example.supplyflow.services.SupplierServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierServices supplierServices;

    public SupplierController(SupplierServices supplierServices) {
        this.supplierServices = supplierServices;
    }

    @GetMapping
    public String listSuppliers(Model model) {
        model.addAttribute("suppliers", supplierServices.findAllSuppliers());
        return "suppliers/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "suppliers/add-supplier";
    }

    @PostMapping("/save")
    public String saveSupplier(@ModelAttribute("supplier") Supplier supplier) {
        supplierServices.saveSupplier(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable int id) {
        supplierServices.deleteSupplierById(id);
        return "redirect:/suppliers";
    }
}