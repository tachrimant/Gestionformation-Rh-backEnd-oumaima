package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.DemandeCongeDto;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.DemandeConge;

@Repository
public interface DemandeCongeDao extends JpaRepository<DemandeConge, Long> {
        public DemandeConge findDemandeCongeByCode(String code);

        public DemandeConge findDemandeCongeByLibelle(String libelle);

        public DemandeConge findDemandeCongeByDateDebut(Date dateDebut);

        public DemandeConge findDemandeCongeByDateFin(Date dateFin);

        public DemandeConge findDemandeCongeByJourCouvrable(int jourCouvrable);

}