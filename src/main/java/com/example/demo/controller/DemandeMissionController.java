package com.example.demo.controller;

import com.example.demo.entities.EtatDemandeMission;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.DemandeMissionDto;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.service.facade.DemandeMissionService;
import com.example.demo.entities.DemandeMission;

@RestController
@RequestMapping("/demandemission")
public class DemandeMissionController {

    @Autowired
    private DemandeMissionService demandemissionService;

    @PostMapping("/")
    public List<DemandeMission> save(@RequestBody DemandeMission demandemission) {
        demandemissionService.save(demandemission);
        return this.findAll();
    }

    @PutMapping("/")
    public List<DemandeMission> edit(@RequestBody DemandeMission demandemission) {
        demandemissionService.edit(demandemission);
        return this.findAll();

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        demandemissionService.deleteById(id);
    }

    @GetMapping("/{id}")
    public DemandeMission findById(@PathVariable Long id) {
        return demandemissionService.findById(id);
    }

    @GetMapping("/")
    public List<DemandeMission> findAll() {
        return demandemissionService.findAll();
    }
    @GetMapping("/code/{code}")
    public DemandeMission findDemandeMissionBycode(@PathVariable String code){
     return  demandemissionService.findDemandeMissionByCode( code );
}

        @GetMapping("/libelle/{libelle}")
    public DemandeMission findDemandeMissionBylibelle(@PathVariable String libelle){
     return  demandemissionService.findDemandeMissionByLibelle( libelle );
}

        @GetMapping("/dateDebut/{dateDebut}")
    public DemandeMission findDemandeMissionBydateDebut(@PathVariable Date dateDebut){
     return  demandemissionService.findDemandeMissionByDatedebut( dateDebut );
}

        @GetMapping("/dateFin/{dateFin}")
    public DemandeMission findDemandeMissionBydateFin(@PathVariable Date dateFin){
     return  demandemissionService.findDemandeMissionByDatefin( dateFin );
}

        @GetMapping("/etat/{etat}")
    public DemandeMission findDemandeMissionByetat(@PathVariable String etat){
     return  demandemissionService.findDemandeMissionByEtat( etat);
  }

    @GetMapping("/cin/{cin}")
    public List<DemandeMission> findDemandeCongeByEmployeCin(@PathVariable String cin) {
        return demandemissionService.findDemandeMissionByEMployeCin(cin);
    }

}