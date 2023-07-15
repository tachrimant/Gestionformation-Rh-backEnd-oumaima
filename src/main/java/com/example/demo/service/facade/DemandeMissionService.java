package com.example.demo.service.facade;

import com.example.demo.entities.DemandeMission;

import com.example.demo.dto.DemandeMissionDto;
import com.example.demo.entities.EtatDemandeMission;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
public interface DemandeMissionService {
    void save(DemandeMission demandemission);
    void edit(DemandeMission demandemission);
    void deleteById(Long id);
    DemandeMission findById(Long id);
    List<DemandeMission> findAll();
    public DemandeMission findDemandeMissionByCode(String code);

        public DemandeMission findDemandeMissionByLibelle(String libelle);

        public DemandeMission findDemandeMissionByDatedebut(Date dateDebut);

        public DemandeMission findDemandeMissionByDatefin(Date dateFin);

        public DemandeMission findDemandeMissionByEtat(String etat);

    public List<DemandeMission> findDemandeMissionByEMployeId(Long id);

    List<DemandeMission> findDemandeMissionByEmployeIdAndLibelle(Long id, String libelle);



}