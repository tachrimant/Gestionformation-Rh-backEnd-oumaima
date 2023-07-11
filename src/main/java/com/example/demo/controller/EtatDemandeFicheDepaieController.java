package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.EtatDemandeFicheDepaieDto;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.service.facade.EtatDemandeFicheDepaieService;
import com.example.demo.entities.EtatDemandeFicheDepaie;

@RestController
@RequestMapping("/etatdemandefichedepaie")
public class EtatDemandeFicheDepaieController {

    @Autowired
    private EtatDemandeFicheDepaieService etatdemandefichedepaieService;

    @PostMapping("/")
    public void save(@RequestBody EtatDemandeFicheDepaie etatdemandefichedepaie) {
        etatdemandefichedepaieService.save(etatdemandefichedepaie);
    }

    @PutMapping("/")
    public void edit(@RequestBody EtatDemandeFicheDepaie etatdemandefichedepaie) {
        etatdemandefichedepaieService.edit(etatdemandefichedepaie);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        etatdemandefichedepaieService.deleteById(id);
    }

    @GetMapping("/{id}")
    public EtatDemandeFicheDepaie findById(@PathVariable Long id) {
        return etatdemandefichedepaieService.findById(id);
    }

    @GetMapping("/")
    public List<EtatDemandeFicheDepaie> findAll() {
        return etatdemandefichedepaieService.findAll();
    }
    @GetMapping("/code/{code}")
    public EtatDemandeFicheDepaie findEtatDemandeFicheDepaieBycode(@PathVariable String code){
     return  etatdemandefichedepaieService.findEtatDemandeFicheDepaieByCode( code );
}

        @GetMapping("/libelle/{libelle}")
    public EtatDemandeFicheDepaie findEtatDemandeFicheDepaieBylibelle(@PathVariable String libelle){
     return  etatdemandefichedepaieService.findEtatDemandeFicheDepaieByLibelle( libelle );
}
}