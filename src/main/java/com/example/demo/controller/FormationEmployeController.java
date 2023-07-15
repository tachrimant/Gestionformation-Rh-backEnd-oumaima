package com.example.demo.controller;


import com.example.demo.entities.Formation;
import com.example.demo.entities.FormationemEmploye;
import com.example.demo.service.facade.FormationEmployeService;
import com.example.demo.service.facade.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formationEmploye")
public class FormationEmployeController {

    @Autowired
    private FormationEmployeService formationEmployeService;

    @PostMapping("/")
    public void save(@RequestBody FormationemEmploye formation) {
        formationEmployeService.save(formation);
    }

    @PutMapping("/")
    public void edit(@RequestBody FormationemEmploye formation) {
        formationEmployeService.edit(formation);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        formationEmployeService.deleteById(id);
    }

    @GetMapping("/id/{id}")
    public FormationemEmploye findById(@PathVariable Long id) {
        return formationEmployeService.findById(id);
    }

    @GetMapping("/")
    public List<FormationemEmploye> findAll() {
        return formationEmployeService.findAll();
    }

    @GetMapping("/code/{code}")
    public List<FormationemEmploye> findFormationemEmployesByCode(@PathVariable String code) {
        return formationEmployeService.findFormationemEmployesByCode(code);
    }

    @GetMapping("/employe/{id}")
    public List<FormationemEmploye> findFormationemEmployesByEmployeId(@PathVariable Long id) {
        return formationEmployeService.findFormationemEmployesByEmployeId(id);
    }

    @GetMapping("/formation/{id}")
    public List<FormationemEmploye> findFormationemEmployesByFormationId(@PathVariable Long id) {
        return formationEmployeService.findFormationemEmployesByFormationId(id);
    }
}
