package com.example.demo.service.facade;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Tache;

import java.util.Date;
import java.util.List;

public interface ContratService {

    void save(Contrat contrat);

    void edit(Contrat contrat);

    void deleteById(Long id);

    Contrat findById(Long id);

    List<Contrat> findAll();

    public Contrat findContratByCode(String code);

    public Contrat findContratByLibelle(String libelle);

    public Contrat findContratByDatedebut(Date dateDebut);

    public Contrat findContratByDatefin(Date dateFin);

    public List<Contrat> findContratByTypeContrat(String typeContrat);

}