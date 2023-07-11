package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.dto.EtatDemandeFicheDepaieDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.facade.EtatDemandeFicheDepaieService;

import com.example.demo.dao.EtatDemandeFicheDepaieDao;
import com.example.demo.entities.EtatDemandeFicheDepaie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class EtatDemandeFicheDepaieServiceImplementation implements EtatDemandeFicheDepaieService {
    @Autowired
    private EtatDemandeFicheDepaieDao etatdemandefichedepaieDao;

    @Override
    public void save(EtatDemandeFicheDepaie etatdemandefichedepaie) {
        etatdemandefichedepaieDao.save(etatdemandefichedepaie);
    }

    @Override
    public void edit(EtatDemandeFicheDepaie etatdemandefichedepaie) {
        etatdemandefichedepaieDao.save(etatdemandefichedepaie);
    }

    @Override
    public void deleteById(Long id) {
        etatdemandefichedepaieDao.deleteById(id);
    }

    @Override
    public EtatDemandeFicheDepaie findById(Long id) {
        return etatdemandefichedepaieDao.findById(id).orElse(null);
    }

    @Override
    public List<EtatDemandeFicheDepaie> findAll() {
        return etatdemandefichedepaieDao.findAll();
    }

    @Override 
    public EtatDemandeFicheDepaie findEtatDemandeFicheDepaieByCode(String code){
      return  etatdemandefichedepaieDao.findEtatDemandeFicheDepaieByCode(code );
}

        @Override 
    public EtatDemandeFicheDepaie findEtatDemandeFicheDepaieByLibelle(String libelle){
      return  etatdemandefichedepaieDao.findEtatDemandeFicheDepaieByLibelle(libelle );
}

}