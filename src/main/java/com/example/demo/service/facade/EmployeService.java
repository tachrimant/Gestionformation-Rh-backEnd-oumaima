package com.example.demo.service.facade;

import com.example.demo.entities.Employe;

import com.example.demo.dto.EmployeDto;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
public interface EmployeService {
    void save(Employe employe);
    void edit(Employe employe);
    void deleteById(Long id);
    Employe findById(Long id);
    List<Employe> findAll();
    public List<Employe> findEmployeByCin(String cin);

        public Employe findEmployeByNom(String nom);

        public Employe findEmployeByPrenom(String prenom);

        public Employe findEmployeByEmail(String email);

        public Employe findEmployeByDatenaissance(Date datenaissance);

}