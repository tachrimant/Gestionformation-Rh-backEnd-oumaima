package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.DemandeCongeDto;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.service.facade.DemandeCongeService;
import com.example.demo.entities.DemandeConge;

@RestController
@RequestMapping("/demandeconge")
public class DemandeCongeController {

    @Autowired
    private DemandeCongeService demandecongeService;

    @PostMapping("/")
    public void save(@RequestBody DemandeConge demandeconge) {
        demandecongeService.save(demandeconge);
    }

    @PutMapping("/")
    public void edit(@RequestBody DemandeConge demandeconge) {
        demandecongeService.edit(demandeconge);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        demandecongeService.deleteById(id);
    }

    @GetMapping("/{id}")
    public DemandeConge findById(@PathVariable Long id) {
        return demandecongeService.findById(id);
    }

    @GetMapping("/")
    public List<DemandeConge> findAll() {
        return demandecongeService.findAll();
    }
    @GetMapping("/code/{code}")
    public DemandeConge findDemandeCongeBycode(@PathVariable String code){
     return  demandecongeService.findDemandeCongeByCode( code );
}

        @GetMapping("/libelle/{libelle}")
    public DemandeConge findDemandeCongeBylibelle(@PathVariable String libelle){
     return  demandecongeService.findDemandeCongeByLibelle( libelle );
}

        @GetMapping("/dateDebut/{dateDebut}")
    public DemandeConge findDemandeCongeBydateDebut(@PathVariable Date dateDebut){
     return  demandecongeService.findDemandeCongeByDatedebut( dateDebut );
}

        @GetMapping("/dateFin/{dateFin}")
    public DemandeConge findDemandeCongeBydateFin(@PathVariable Date dateFin){
     return  demandecongeService.findDemandeCongeByDatefin( dateFin );
}

        @GetMapping("/jourCouvrable/{jourCouvrable}")
    public DemandeConge findDemandeCongeByjourCouvrable(@PathVariable int jourCouvrable){
     return  demandecongeService.findDemandeCongeByJourcouvrable( jourCouvrable );
    }

    @GetMapping("/etat/{etat}")
    public List<DemandeConge> findDemandeCongeByEtat(@PathVariable String etat) {
        return demandecongeService.findDemandeCongeByEtat(etat);
    }
}

