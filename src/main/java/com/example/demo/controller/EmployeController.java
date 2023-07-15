package com.example.demo.controller;

import com.example.demo.zynerator.security.bean.Role;
import com.example.demo.zynerator.security.common.AuthoritiesConstants;
import com.example.demo.zynerator.security.service.facade.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.EmployeDto;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.Collectors;

import com.example.demo.service.facade.EmployeService;
import com.example.demo.entities.Employe;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/")
    public List<Employe> save(@RequestBody Employe employe) {
        employeService.save(employe);
        Role role = roleService.findByAuthority(AuthoritiesConstants.USER);
        return this.findAll().stream().filter(employe1 -> employe1.getRoles().contains(role)).collect(Collectors.toList());
    }

    @PutMapping("/")
    public List<Employe> edit(@RequestBody Employe employe) {
        employeService.edit(employe);
        Role role = roleService.findByAuthority(AuthoritiesConstants.USER);
        return this.findAll().stream().filter(employe1 -> employe1.getRoles().contains(role)).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public List<Employe> deleteById(@PathVariable Long id) {
        employeService.deleteById(id);
        Role role = roleService.findByAuthority(AuthoritiesConstants.USER);
        return this.findAll().stream().filter(employe1 -> employe1.getRoles().contains(role)).collect(Collectors.toList());
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
        Role role = roleService.findByAuthority(AuthoritiesConstants.USER);
     return  employeService.findEmployeByCin( cin ).stream().filter(employe1 -> employe1.getRoles().contains(role)).collect(Collectors.toList());
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