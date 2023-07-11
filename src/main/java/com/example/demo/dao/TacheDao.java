package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.TacheDto;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.Tache;

@Repository
public interface TacheDao extends JpaRepository<Tache, Long> {
        public Tache findTacheByCode(String code);

        public Tache findTacheByLibelle(String libelle);

        public Tache findTacheByDateDebut(Date dateDebut);

        public Tache findTacheByDateFin(Date dateFin);

}