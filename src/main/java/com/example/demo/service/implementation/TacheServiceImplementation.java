package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.dto.TacheDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.facade.TacheService;

import com.example.demo.dao.TacheDao;
import com.example.demo.entities.Tache;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class TacheServiceImplementation implements TacheService {
    @Autowired
    private TacheDao tacheDao;

    @Override
    public void save(Tache tache) {
        tacheDao.save(tache);
    }

    @Override
    public void edit(Tache tache) {
        Tache tache1 = findById(tache.getId());
        if (tache1 != null){
            tache1.setDateDebut(tache.getDateDebut());
            tache1.setDateFin(tache.getDateFin());
            tache1.setEmploye(tache.getEmploye());
            tache1.setLibelle(tache.getLibelle());
            tache1.setProjet(tache.getProjet());
            tacheDao.saveAndFlush(tache1);
        }
    }

    @Override
    public void deleteById(Long id) {
        tacheDao.deleteById(id);
    }

    @Override
    public Tache findById(Long id) {
        return tacheDao.findById(id).orElse(null);
    }

    @Override
    public List<Tache> findAll() {
        return tacheDao.findAll();
    }

    @Override 
    public Tache findTacheByCode(String code){
      return  tacheDao.findTacheByCode(code );
}

        @Override 
    public Tache findTacheByLibelle(String libelle){
      return  tacheDao.findTacheByLibelle(libelle );
}

        @Override 
    public Tache findTacheByDatedebut(Date dateDebut){
      return  tacheDao.findTacheByDateDebut(dateDebut );
}

        @Override 
    public Tache findTacheByDatefin(Date dateFin){
      return  tacheDao.findTacheByDateFin(dateFin );
}

}