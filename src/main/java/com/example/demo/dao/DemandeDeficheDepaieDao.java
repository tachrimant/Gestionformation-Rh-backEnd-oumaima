package com.example.demo.dao;

import com.example.demo.entities.DemandeConge;
import com.example.demo.entities.EtatDemandeFicheDepaie;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.DemandeDeficheDepaieDto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.DemandeDeficheDepaie;

@Repository
public interface DemandeDeficheDepaieDao extends JpaRepository<DemandeDeficheDepaie, Long> {

        @Query(value = "SELECT d FROM DemandeDeficheDepaie d WHERE d.code LIKE CONCAT('%', :code, '%')")
        public List<DemandeDeficheDepaie> findDemandeDeficheDepaieByCode(String code);

        @Query(value = "SELECT d FROM DemandeDeficheDepaie d WHERE d.employe.id = :id")
        List<DemandeDeficheDepaie> findDemandeDeficheDepaieByEmployeId(Long id);

        public DemandeDeficheDepaie findDemandeDeficheDepaieByDatedemande(Date datedemande);

        public DemandeDeficheDepaie findDemandeDeficheDepaieByEtat(String etat);


}