package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.test.service.facade.ProduitService;
import com.example.test.entities.Produit;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @PostMapping("/")
    public void save(@RequestBody Produit produit) {
        produitService.save(produit);
    }

    @PutMapping("/")
    public void edit(@RequestBody Produit produit) {
        produitService.edit(produit);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        produitService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Produit findById(@PathVariable Long id) {
        return produitService.findById(id);
    }

    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }
}