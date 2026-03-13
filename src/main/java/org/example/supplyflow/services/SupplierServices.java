package org.example.supplyflow.services;

import org.example.supplyflow.entities.Supplier;
import org.example.supplyflow.repositories.SupplierRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServices {
    private final SupplierRepos supplierRepos;

    public SupplierServices(SupplierRepos supplierRepos) {
        this.supplierRepos = supplierRepos;
    }

    public void saveSupplier(Supplier supplier){
        supplierRepos.save(supplier);
    }
    public Supplier findSupplierById(int id){
        return supplierRepos.findById(id).orElse(null);
    }
    public List<Supplier> findAllSuppliers(){
        return supplierRepos.findAll();
    }
    public void deleteSupplierById(int id){
        supplierRepos.deleteById(id);
    }
}
