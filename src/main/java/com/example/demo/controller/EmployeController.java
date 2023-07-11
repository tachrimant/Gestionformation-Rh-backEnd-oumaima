package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.EmployeDto;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.service.facade.EmployeService;
import com.example.demo.entities.Employe;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @PostMapping("/")
    public List<Employe> save(@RequestBody Employe employe) {
        employeService.save(employe);
        return this.findAll();
    }

    @PutMapping("/")
    public void edit(@RequestBody Employe employe) {
        employeService.edit(employe);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        employeService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Employe findById(@PathVariable Long id) {
        return employeService.findById(id);
    }

    @GetMapping("/")
    public List<Employe> findAll() {
        return employeService.findAll();
    }
    @GetMapping("/cin/{cin}")
    public List<Employe> findEmployeBycin(@PathVariable String cin){
     return  employeService.findEmployeByCin( cin );
}

        @GetMapping("/nom/{nom}")
    public Employe findEmployeBynom(@PathVariable String nom){
     return  employeService.findEmployeByNom( nom );
}

        @GetMapping("/prenom/{prenom}")
    public Employe findEmployeByprenom(@PathVariable String prenom){
     return  employeService.findEmployeByPrenom( prenom );
}

        @GetMapping("/email/{email}")
    public Employe findEmployeByemail(@PathVariable String email){
     return  employeService.findEmployeByEmail( email );
}

        @GetMapping("/datenaissance/{datenaissance}")
    public Employe findEmployeBydatenaissance(@PathVariable Date datenaissance){
     return  employeService.findEmployeByDatenaissance( datenaissance );
}
}