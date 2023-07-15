package com.example.demo.dao;

import com.example.demo.entities.EtatDemandeMission;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.DemandeMissionDto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.DemandeMission;

@Repository
public interface DemandeMissionDao extends JpaRepository<DemandeMission, Long> {
        public DemandeMission findDemandeMissionByCode(String code);

        @Query(value = "SELECT d FROM DemandeMission d WHERE d.libelle LIKE CONCAT('%', :libelle, '%')")
        public DemandeMission findDemandeMissionByLibelle(String libelle);

        @Query(value = "SELECT d FROM DemandeMission d WHERE d.employee.cin LIKE CONCAT('%', :cin, '%')")
        List<DemandeMission> findDemandeMissionByEmployeCin(String cin);


        public DemandeMission findDemandeMissionByDateDebut(Date dateDebut);

        public DemandeMission findDemandeMissionByDateFin(Date dateFin);

        public DemandeMission findDemandeMissionByEtat(String etat);

}