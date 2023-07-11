package com.example.demo.service.facade;

import com.example.demo.entities.DemandeConge;

import com.example.demo.dto.DemandeCongeDto;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
public interface DemandeCongeService {
    void save(DemandeConge demandeconge);
    void edit(DemandeConge demandeconge);
    void deleteById(Long id);
    DemandeConge findById(Long id);
    List<DemandeConge> findAll();
    public DemandeConge findDemandeCongeByCode(String code);

        public DemandeConge findDemandeCongeByLibelle(String libelle);

        public DemandeConge findDemandeCongeByDatedebut(Date dateDebut);

        public DemandeConge findDemandeCongeByDatefin(Date dateFin);

        public DemandeConge findDemandeCongeByJourcouvrable(int jourCouvrable);

}