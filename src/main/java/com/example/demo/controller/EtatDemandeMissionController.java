package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.EtatDemandeMissionDto;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.service.facade.EtatDemandeMissionService;
import com.example.demo.entities.EtatDemandeMission;

@RestController
@RequestMapping("/etatdemandemission")
public class EtatDemandeMissionController {

    @Autowired
    private EtatDemandeMissionService etatdemandemissionService;

    @PostMapping("/")
    public void save(@RequestBody EtatDemandeMission etatdemandemission) {
        etatdemandemissionService.save(etatdemandemission);
    }

    @PutMapping("/")
    public void edit(@RequestBody EtatDemandeMission etatdemandemission) {
        etatdemandemissionService.edit(etatdemandemission);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        etatdemandemissionService.deleteById(id);
    }

    @GetMapping("/{id}")
    public EtatDemandeMission findById(@PathVariable Long id) {
        return etatdemandemissionService.findById(id);
    }

    @GetMapping("/")
    public List<EtatDemandeMission> findAll() {
        return etatdemandemissionService.findAll();
    }
    @GetMapping("/code/{code}")
    public EtatDemandeMission findEtatDemandeMissionBycode(@PathVariable String code){
     return  etatdemandemissionService.findEtatDemandeMissionByCode( code );
}

        @GetMapping("/libelle/{libelle}")
    public EtatDemandeMission findEtatDemandeMissionBylibelle(@PathVariable String libelle){
     return  etatdemandemissionService.findEtatDemandeMissionByLibelle( libelle );
}
}