package com.example.demo.service.facade;

import com.example.demo.entities.DemandeDeficheDepaie;

import com.example.demo.dto.DemandeDeficheDepaieDto;
import com.example.demo.entities.EtatDemandeFicheDepaie;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
public interface DemandeDeficheDepaieService {
    void save(DemandeDeficheDepaie demandedefichedepaie);
    void edit(DemandeDeficheDepaie demandedefichedepaie);
    void deleteById(Long id);
    DemandeDeficheDepaie findById(Long id);
    List<DemandeDeficheDepaie> findAll();

    public List<DemandeDeficheDepaie> findDemandeDeficheDepaieByCode(String code);

        public DemandeDeficheDepaie findDemandeDeficheDepaieByDatedemande(Date datedemande);

        public DemandeDeficheDepaie findDemandeDeficheDepaieByEtat(String etat);

}