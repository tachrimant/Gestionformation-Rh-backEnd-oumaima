package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.dto.DemandeCongeDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.facade.DemandeCongeService;

import com.example.demo.dao.DemandeCongeDao;
import com.example.demo.entities.DemandeConge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class DemandeCongeServiceImplementation implements DemandeCongeService {
    @Autowired
    private DemandeCongeDao demandecongeDao;

    @Override
    public void save(DemandeConge demandeconge) {
        demandecongeDao.save(demandeconge);
    }

    @Override
    public void edit(DemandeConge demandeconge) {
        demandecongeDao.save(demandeconge);
    }

    @Override
    public void deleteById(Long id) {
        demandecongeDao.deleteById(id);
    }

    @Override
    public DemandeConge findById(Long id) {
        return demandecongeDao.findById(id).orElse(null);
    }

    @Override
    public List<DemandeConge> findAll() {
        return demandecongeDao.findAll();
    }

    @Override 
    public DemandeConge findDemandeCongeByCode(String code){
      return  demandecongeDao.findDemandeCongeByCode(code );
}

        @Override 
    public List<DemandeConge> findDemandeCongeByLibelle(String libelle){
      return  demandecongeDao.findDemandeCongeByLibelle(libelle );
}

        @Override 
    public DemandeConge findDemandeCongeByDatedebut(Date dateDebut){
      return  demandecongeDao.findDemandeCongeByDateDebut(dateDebut );
}

        @Override 
    public DemandeConge findDemandeCongeByDatefin(Date dateFin){
      return  demandecongeDao.findDemandeCongeByDateFin(dateFin );
}

        @Override 
    public DemandeConge findDemandeCongeByJourcouvrable(int jourCouvrable){
      return  demandecongeDao.findDemandeCongeByJourCouvrable(jourCouvrable );
}

    @Override
    public List<DemandeConge> findDemandeCongeByEtat(String etat) {
        return demandecongeDao.findDemandeCongeByEtat(etat);
    }

    @Override
    public List<DemandeConge> findDemandeCongeByEMployeCin(String cin) {
        return demandecongeDao.findDemandeCongeByEmployeCin(cin);
    }
}