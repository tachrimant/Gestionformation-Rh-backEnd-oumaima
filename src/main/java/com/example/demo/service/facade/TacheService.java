package com.example.demo.service.facade;

import com.example.demo.entities.Tache;

import com.example.demo.dto.TacheDto;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
public interface TacheService {
    void save(Tache tache);
    void edit(Tache tache);
    void deleteById(Long id);
    Tache findById(Long id);
    List<Tache> findAll();
    public List<Tache> findTacheByCode(String code);

        public Tache findTacheByLibelle(String libelle);

        public Tache findTacheByDatedebut(Date dateDebut);

        public Tache findTacheByDatefin(Date dateFin);

}