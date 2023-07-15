package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.dto.DemandeDeficheDepaieDto;

import com.example.demo.entities.EtatDemandeFicheDepaie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.facade.DemandeDeficheDepaieService;

import com.example.demo.dao.DemandeDeficheDepaieDao;
import com.example.demo.entities.DemandeDeficheDepaie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class DemandeDeficheDepaieServiceImplementation implements DemandeDeficheDepaieService {
    @Autowired
    private DemandeDeficheDepaieDao demandedefichedepaieDao;

    @Override
    public void save(DemandeDeficheDepaie demandedefichedepaie) {
        demandedefichedepaieDao.save(demandedefichedepaie);
    }

    @Override
    public void edit(DemandeDeficheDepaie demandedefichedepaie) {
        DemandeDeficheDepaie demandeDeficheDepaie = findById(demandedefichedepaie.getId());
        if (demandeDeficheDepaie != null){
            demandeDeficheDepaie.setDatedemande(demandeDeficheDepaie.getDatedemande());
            demandeDeficheDepaie.setEmploye(demandedefichedepaie.getEmploye());
            demandeDeficheDepaie.setEtat(demandedefichedepaie.getEtat());
            demandeDeficheDepaie.setDateEnvoieFiche(demandedefichedepaie.getDateEnvoieFiche());
            demandedefichedepaieDao.save(demandedefichedepaie);
        }
    }

    @Override
    public void deleteById(Long id) {
        demandedefichedepaieDao.deleteById(id);
    }

    @Override
    public DemandeDeficheDepaie findById(Long id) {
        return demandedefichedepaieDao.findById(id).orElse(null);
    }

    @Override
    public List<DemandeDeficheDepaie> findAll() {
        return demandedefichedepaieDao.findAll();
    }

    @Override 
    public List<DemandeDeficheDepaie> findDemandeDeficheDepaieByCode(String code){
      return  demandedefichedepaieDao.findDemandeDeficheDepaieByCode(code );
}

        @Override 
    public DemandeDeficheDepaie findDemandeDeficheDepaieByDatedemande(Date datedemande){
      return  demandedefichedepaieDao.findDemandeDeficheDepaieByDatedemande(datedemande );
}

        @Override 
    public DemandeDeficheDepaie findDemandeDeficheDepaieByEtat(String etat){
      return  demandedefichedepaieDao.findDemandeDeficheDepaieByEtat(etat);
}

    @Override
    public List<DemandeDeficheDepaie> findDemandeDeficheDepaieByEMployeId(Long id) {
        return  demandedefichedepaieDao.findDemandeDeficheDepaieByEmployeId(id);

    }

}