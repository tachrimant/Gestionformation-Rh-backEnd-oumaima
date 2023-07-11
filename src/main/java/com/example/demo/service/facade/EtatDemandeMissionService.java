package com.example.demo.service.facade;

import com.example.demo.entities.EtatDemandeMission;

import com.example.demo.dto.EtatDemandeMissionDto;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
public interface EtatDemandeMissionService {
    void save(EtatDemandeMission etatdemandemission);
    void edit(EtatDemandeMission etatdemandemission);
    void deleteById(Long id);
    EtatDemandeMission findById(Long id);
    List<EtatDemandeMission> findAll();
    public EtatDemandeMission findEtatDemandeMissionByCode(String code);

        public EtatDemandeMission findEtatDemandeMissionByLibelle(String libelle);

}