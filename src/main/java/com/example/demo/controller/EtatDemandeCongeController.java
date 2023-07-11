package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.EtatDemandeCongeDto;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.service.facade.EtatDemandeCongeService;
import com.example.demo.entities.EtatDemandeConge;

@RestController
@RequestMapping("/etatdemandeconge")
public class EtatDemandeCongeController {

    @Autowired
    private EtatDemandeCongeService etatdemandecongeService;

    @PostMapping("/")
    public void save(@RequestBody EtatDemandeConge etatdemandeconge) {
        etatdemandecongeService.save(etatdemandeconge);
    }

    @PutMapping("/")
    public void edit(@RequestBody EtatDemandeConge etatdemandeconge) {
        etatdemandecongeService.edit(etatdemandeconge);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        etatdemandecongeService.deleteById(id);
    }

    @GetMapping("/{id}")
    public EtatDemandeConge findById(@PathVariable Long id) {
        return etatdemandecongeService.findById(id);
    }

    @GetMapping("/")
    public List<EtatDemandeConge> findAll() {
        return etatdemandecongeService.findAll();
    }
    @GetMapping("/code/{code}")
    public EtatDemandeConge findEtatDemandeCongeBycode(@PathVariable String code){
     return  etatdemandecongeService.findEtatDemandeCongeByCode( code );
}

        @GetMapping("/libelle/{libelle}")
    public EtatDemandeConge findEtatDemandeCongeBylibelle(@PathVariable String libelle){
     return  etatdemandecongeService.findEtatDemandeCongeByLibelle( libelle );
}
}