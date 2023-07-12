package com.example.demo.controller;

import com.example.demo.entities.Contrat;
import com.example.demo.service.facade.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    private ContratService contratService;

    @PostMapping("/")
    public List<Contrat> save(@RequestBody Contrat contrat) {
        contratService.save(contrat);

        return this.findAll();
    }

    @PutMapping("/")
    public List<Contrat> edit(@RequestBody Contrat contrat) {
        contratService.edit(contrat);
        return this.findAll();
    }

    @DeleteMapping("/{id}")
    public List<Contrat> deleteById(@PathVariable Long id) {
        contratService.deleteById(id);
        return this.findAll();
    }

    @GetMapping("/{id}")
    public Contrat findById(@PathVariable Long id) {
        return contratService.findById(id);
    }

    @GetMapping("/")
    public List<Contrat> findAll() {
        return contratService.findAll();
    }
    @GetMapping("/code/{code}")
    public Contrat findContratBycode(@PathVariable String code){
     return  contratService.findContratByCode( code );
}

        @GetMapping("/libelle/{libelle}")
    public Contrat findContratBylibelle(@PathVariable String libelle){
     return  contratService.findContratByLibelle( libelle );
}

        @GetMapping("/dateDebut/{dateDebut}")
    public Contrat findContratBydateDebut(@PathVariable Date dateDebut){
     return  contratService.findContratByDatedebut( dateDebut );
}

    @GetMapping("/dateFin/{dateFin}")
    public Contrat findContratBydateFin(@PathVariable Date dateFin){
     return  contratService.findContratByDatefin( dateFin );
   }


    @GetMapping("/typeContrat/{typeContrat}")
    public List<Contrat> findContratByTypeContrat(@PathVariable String typeContrat) {
        return contratService.findContratByTypeContrat(typeContrat);
    }
}