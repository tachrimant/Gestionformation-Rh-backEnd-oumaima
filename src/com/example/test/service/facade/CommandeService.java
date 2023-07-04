package com.example.test.service.facade;

import com.example.test.entities.Commande;

import java.util.List;

public interface CommandeService {
    void save(Commande commande);
    void edit(Commande commande);
    void deleteById(Long id);
    Commande findById(Long id);
    List<Commande> findAll();
}