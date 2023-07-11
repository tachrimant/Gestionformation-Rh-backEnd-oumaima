package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.dto.EtatDemandeCongeDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.facade.EtatDemandeCongeService;

import com.example.demo.dao.EtatDemandeCongeDao;
import com.example.demo.entities.EtatDemandeConge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class EtatDemandeCongeServiceImplementation implements EtatDemandeCongeService {
    @Autowired
    private EtatDemandeCongeDao etatdemandecongeDao;

    @Override
    public void save(EtatDemandeConge etatdemandeconge) {
        etatdemandecongeDao.save(etatdemandeconge);
    }

    @Override
    public void edit(EtatDemandeConge etatdemandeconge) {
        etatdemandecongeDao.save(etatdemandeconge);
    }

    @Override
    public void deleteById(Long id) {
        etatdemandecongeDao.deleteById(id);
    }

    @Override
    public EtatDemandeConge findById(Long id) {
        return etatdemandecongeDao.findById(id).orElse(null);
    }

    @Override
    public List<EtatDemandeConge> findAll() {
        return etatdemandecongeDao.findAll();
    }

    @Override 
    public EtatDemandeConge findEtatDemandeCongeByCode(String code){
      return  etatdemandecongeDao.findEtatDemandeCongeByCode(code );
}

        @Override 
    public EtatDemandeConge findEtatDemandeCongeByLibelle(String libelle){
      return  etatdemandecongeDao.findEtatDemandeCongeByLibelle(libelle );
}

}