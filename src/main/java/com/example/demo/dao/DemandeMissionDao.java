package com.example.demo.dao;

import com.example.demo.entities.EtatDemandeMission;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.DemandeMissionDto;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.DemandeMission;

@Repository
public interface DemandeMissionDao extends JpaRepository<DemandeMission, Long> {
        public DemandeMission findDemandeMissionByCode(String code);

        public DemandeMission findDemandeMissionByLibelle(String libelle);

        public DemandeMission findDemandeMissionByDateDebut(Date dateDebut);

        public DemandeMission findDemandeMissionByDateFin(Date dateFin);

        public DemandeMission findDemandeMissionByEtat(String etat);

}