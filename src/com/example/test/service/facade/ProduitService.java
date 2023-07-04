package com.example.test.service.facade;

import com.example.test.entities.Produit;

import java.util.List;

public interface ProduitService {
    void save(Produit produit);
    void edit(Produit produit);
    void deleteById(Long id);
    Produit findById(Long id);
    List<Produit> findAll();
}