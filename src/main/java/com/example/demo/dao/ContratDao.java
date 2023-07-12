package com.example.demo.dao;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratDao extends JpaRepository<Contrat, Long> {
        public Contrat findContratByCode(String code);

        public Contrat findContratByLibelle(String libelle);

        public Contrat findContratByDateDebut(Date dateDebut);

        public Contrat findContratByDateFin(Date dateFin);

        public List<Contrat> findContratByTypeContrat(String typeContrat);

}