package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.EtatDemandeCongeDto;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.EtatDemandeConge;

@Repository
public interface EtatDemandeCongeDao extends JpaRepository<EtatDemandeConge, Long> {
        public EtatDemandeConge findEtatDemandeCongeByCode(String code);

        public EtatDemandeConge findEtatDemandeCongeByLibelle(String libelle);

}