package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.TacheDto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.Tache;

@Repository
public interface TacheDao extends JpaRepository<Tache, Long> {

        @Query(value = "SELECT c FROM Tache c WHERE c.projet.libelle LIKE CONCAT('%', :code, '%')")

        public List<Tache> findTacheByCode(String code);

        public List<Tache> findTachesByEmployeId(Long id);

        @Query(value = "SELECT t FROM Tache t WHERE t.projet.libelle LIKE CONCAT('%', :libelle, '%') AND t.employe.id = :id")
        List<Tache> findTacheByEmployeIdAndLibelle(Long id, String libelle);

        public Tache findTacheByLibelle(String libelle);

        public Tache findTacheByDateDebut(Date dateDebut);

        public Tache findTacheByDateFin(Date dateFin);

}