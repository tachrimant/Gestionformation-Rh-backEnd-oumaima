package com.example.demo.service.facade;

import com.example.demo.entities.Projet;

import com.example.demo.dto.ProjetDto;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
public interface ProjetService {
    void save(Projet projet);
    void edit(Projet projet);
    void deleteById(Long id);
    Projet findById(Long id);
    List<Projet> findAll();
    public Projet findProjetByCode(String code);

        public Projet findProjetByLibelle(String libelle);

        public Projet findProjetByDatedebut(Date dateDebut);

        public Projet findProjetByDatefin(Date dateFin);

}