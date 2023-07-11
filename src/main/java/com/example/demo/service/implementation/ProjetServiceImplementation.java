package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.dto.ProjetDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.facade.ProjetService;

import com.example.demo.dao.ProjetDao;
import com.example.demo.entities.Projet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ProjetServiceImplementation implements ProjetService {
    @Autowired
    private ProjetDao projetDao;

    @Override
    public void save(Projet projet) {
        projetDao.save(projet);
    }

    @Override
    public void edit(Projet projet) {
        projetDao.save(projet);
    }

    @Override
    public void deleteById(Long id) {
        projetDao.deleteById(id);
    }

    @Override
    public Projet findById(Long id) {
        return projetDao.findById(id).orElse(null);
    }

    @Override
    public List<Projet> findAll() {
        return projetDao.findAll();
    }

    @Override 
    public Projet findProjetByCode(String code){
      return  projetDao.findProjetByCode(code );
}

        @Override 
    public Projet findProjetByLibelle(String libelle){
      return  projetDao.findProjetByLibelle(libelle );
}

        @Override 
    public Projet findProjetByDatedebut(Date dateDebut){
      return  projetDao.findProjetByDateDebut(dateDebut );
}

        @Override 
    public Projet findProjetByDatefin(Date dateFin){
      return  projetDao.findProjetByDateFin(dateFin );
}

}