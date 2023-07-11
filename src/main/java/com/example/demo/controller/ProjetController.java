package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.ProjetDto;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.service.facade.ProjetService;
import com.example.demo.entities.Projet;

@RestController
@RequestMapping("/projet")
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    @PostMapping("/")
    public void save(@RequestBody Projet projet) {
        projetService.save(projet);
    }

    @PutMapping("/")
    public void edit(@RequestBody Projet projet) {
        projetService.edit(projet);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        projetService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Projet findById(@PathVariable Long id) {
        return projetService.findById(id);
    }

    @GetMapping("/")
    public List<Projet> findAll() {
        return projetService.findAll();
    }
    @GetMapping("/code/{code}")
    public Projet findProjetBycode(@PathVariable String code){
     return  projetService.findProjetByCode( code );
}

        @GetMapping("/libelle/{libelle}")
    public Projet findProjetBylibelle(@PathVariable String libelle){
     return  projetService.findProjetByLibelle( libelle );
}

        @GetMapping("/dateDebut/{dateDebut}")
    public Projet findProjetBydateDebut(@PathVariable Date dateDebut){
     return  projetService.findProjetByDatedebut( dateDebut );
}

        @GetMapping("/dateFin/{dateFin}")
    public Projet findProjetBydateFin(@PathVariable Date dateFin){
     return  projetService.findProjetByDatefin( dateFin );
}
}