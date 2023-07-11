package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.dto.EtatDemandeMissionDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.facade.EtatDemandeMissionService;

import com.example.demo.dao.EtatDemandeMissionDao;
import com.example.demo.entities.EtatDemandeMission;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class EtatDemandeMissionServiceImplementation implements EtatDemandeMissionService {
    @Autowired
    private EtatDemandeMissionDao etatdemandemissionDao;

    @Override
    public void save(EtatDemandeMission etatdemandemission) {
        etatdemandemissionDao.save(etatdemandemission);
    }

    @Override
    public void edit(EtatDemandeMission etatdemandemission) {
        etatdemandemissionDao.save(etatdemandemission);
    }

    @Override
    public void deleteById(Long id) {
        etatdemandemissionDao.deleteById(id);
    }

    @Override
    public EtatDemandeMission findById(Long id) {
        return etatdemandemissionDao.findById(id).orElse(null);
    }

    @Override
    public List<EtatDemandeMission> findAll() {
        return etatdemandemissionDao.findAll();
    }

    @Override 
    public EtatDemandeMission findEtatDemandeMissionByCode(String code){
      return  etatdemandemissionDao.findEtatDemandeMissionByCode(code );
}

        @Override 
    public EtatDemandeMission findEtatDemandeMissionByLibelle(String libelle){
      return  etatdemandemissionDao.findEtatDemandeMissionByLibelle(libelle );
}

}