package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.ProjetDto;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.Projet;

@Repository
public interface ProjetDao extends JpaRepository<Projet, Long> {
        public Projet findProjetByCode(String code);

        public Projet findProjetByLibelle(String libelle);

        public Projet findProjetByDateDebut(Date dateDebut);

        public Projet findProjetByDateFin(Date dateFin);

}