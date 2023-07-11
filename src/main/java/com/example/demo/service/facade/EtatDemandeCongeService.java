package com.example.demo.service.facade;

import com.example.demo.entities.EtatDemandeConge;

import com.example.demo.dto.EtatDemandeCongeDto;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
public interface EtatDemandeCongeService {
    void save(EtatDemandeConge etatdemandeconge);
    void edit(EtatDemandeConge etatdemandeconge);
    void deleteById(Long id);
    EtatDemandeConge findById(Long id);
    List<EtatDemandeConge> findAll();
    public EtatDemandeConge findEtatDemandeCongeByCode(String code);

        public EtatDemandeConge findEtatDemandeCongeByLibelle(String libelle);

}