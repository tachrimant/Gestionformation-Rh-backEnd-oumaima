package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.test.service.facade.CommandeService;
import com.example.test.entities.Commande;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @PostMapping("/")
    public void save(@RequestBody Commande commande) {
        commandeService.save(commande);
    }

    @PutMapping("/")
    public void edit(@RequestBody Commande commande) {
        commandeService.edit(commande);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        commandeService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Commande findById(@PathVariable Long id) {
        return commandeService.findById(id);
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }
}