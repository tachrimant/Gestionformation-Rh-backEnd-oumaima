package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.EtatDemandeMissionDto;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.EtatDemandeMission;

@Repository
public interface EtatDemandeMissionDao extends JpaRepository<EtatDemandeMission, Long> {
        public EtatDemandeMission findEtatDemandeMissionByCode(String code);

        public EtatDemandeMission findEtatDemandeMissionByLibelle(String libelle);

}