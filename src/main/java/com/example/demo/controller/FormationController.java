package com.example.demo.controller;


import com.example.demo.entities.Formation;
import com.example.demo.service.facade.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/formation")
public class FormationController {


    @Autowired
    private FormationService formationService;


    @PostMapping("/")
    public void save(@RequestBody Formation formation) {
        formationService.save(formation);
    }


    @PutMapping("/")
    public void edit(@RequestBody Formation formation) {
        formationService.edit(formation);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        formationService.deleteById(id);
    }

    @GetMapping("/id/{id}")
    public Formation findById(@PathVariable Long id) {
        return formationService.findById(id);
    }

    @GetMapping("/")
    public List<Formation> findAll() {
        return formationService.findAll();
    }

    @GetMapping("/code/{code}")
    public List<Formation> findFormationByCode(@PathVariable String code) {
        return formationService.findFormationByCode(code);
    }

    @GetMapping("/title/{title}")
    public List<Formation> findFormationByTitle(@PathVariable String title) {
        return formationService.findFormationByTitle(title);
    }

}
