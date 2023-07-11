package com.example.demo.controller;

import com.example.demo.entities.EtatDemandeFicheDepaie;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.DemandeDeficheDepaieDto;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.service.facade.DemandeDeficheDepaieService;
import com.example.demo.entities.DemandeDeficheDepaie;

@RestController
@RequestMapping("/demandedefichedepaie")
public class DemandeDeficheDepaieController {

    @Autowired
    private DemandeDeficheDepaieService demandedefichedepaieService;

    @PostMapping("/")
    public void save(@RequestBody DemandeDeficheDepaie demandedefichedepaie) {
        demandedefichedepaieService.save(demandedefichedepaie);
    }

    @PutMapping("/")
    public void edit(@RequestBody DemandeDeficheDepaie demandedefichedepaie) {
        demandedefichedepaieService.edit(demandedefichedepaie);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        demandedefichedepaieService.deleteById(id);
    }

    @GetMapping("/{id}")
    public DemandeDeficheDepaie findById(@PathVariable Long id) {
        return demandedefichedepaieService.findById(id);
    }

    @GetMapping("/")
    public List<DemandeDeficheDepaie> findAll() {
        return demandedefichedepaieService.findAll();
    }
    @GetMapping("/code/{code}")
    public DemandeDeficheDepaie findDemandeDeficheDepaieBycode(@PathVariable String code){
     return  demandedefichedepaieService.findDemandeDeficheDepaieByCode( code );
}

        @GetMapping("/datedemande/{datedemande}")
    public DemandeDeficheDepaie findDemandeDeficheDepaieBydatedemande(@PathVariable Date datedemande){
     return  demandedefichedepaieService.findDemandeDeficheDepaieByDatedemande( datedemande );
}

        @GetMapping("/etat/{etat}")
    public DemandeDeficheDepaie findDemandeDeficheDepaieByetat(@PathVariable EtatDemandeFicheDepaie etat){
     return  demandedefichedepaieService.findDemandeDeficheDepaieByEtat( etat );
}
}