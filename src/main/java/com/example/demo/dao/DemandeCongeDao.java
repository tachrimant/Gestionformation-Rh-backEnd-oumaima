package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.DemandeCongeDto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.DemandeConge;

@Repository
public interface DemandeCongeDao extends JpaRepository<DemandeConge, Long> {
        public DemandeConge findDemandeCongeByCode(String code);


        @Query(value = "SELECT d FROM DemandeConge d WHERE d.libelle LIKE CONCAT('%', :libelle, '%')")
        public List<DemandeConge> findDemandeCongeByLibelle(String libelle);

        @Query(value = "SELECT d FROM DemandeConge d WHERE d.employee.id = :id")
        List<DemandeConge> findDemandeCongeByEmployeId(Long id);

        @Query(value = "SELECT d FROM DemandeConge d WHERE d.libelle LIKE CONCAT('%', :libelle, '%') AND d.employee.id = :id")
        List<DemandeConge> findDemandeCongeByEmployeIdAndLibelle(Long id, String libelle);

        public DemandeConge findDemandeCongeByDateDebut(Date dateDebut);

        public DemandeConge findDemandeCongeByDateFin(Date dateFin);

        public DemandeConge findDemandeCongeByJourCouvrable(int jourCouvrable);

        public List<DemandeConge> findDemandeCongeByEtat(String etat);

}