package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.EtatDemandeFicheDepaieDto;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.EtatDemandeFicheDepaie;

@Repository
public interface EtatDemandeFicheDepaieDao extends JpaRepository<EtatDemandeFicheDepaie, Long> {
        public EtatDemandeFicheDepaie findEtatDemandeFicheDepaieByCode(String code);

        public EtatDemandeFicheDepaie findEtatDemandeFicheDepaieByLibelle(String libelle);

}