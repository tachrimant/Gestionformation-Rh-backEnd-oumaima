package com.example.demo.service.facade;

import com.example.demo.entities.EtatDemandeFicheDepaie;

import com.example.demo.dto.EtatDemandeFicheDepaieDto;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
public interface EtatDemandeFicheDepaieService {
    void save(EtatDemandeFicheDepaie etatdemandefichedepaie);
    void edit(EtatDemandeFicheDepaie etatdemandefichedepaie);
    void deleteById(Long id);
    EtatDemandeFicheDepaie findById(Long id);
    List<EtatDemandeFicheDepaie> findAll();
    public EtatDemandeFicheDepaie findEtatDemandeFicheDepaieByCode(String code);

        public EtatDemandeFicheDepaie findEtatDemandeFicheDepaieByLibelle(String libelle);

}