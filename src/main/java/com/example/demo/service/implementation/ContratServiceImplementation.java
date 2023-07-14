package com.example.demo.service.implementation;

import com.example.demo.dao.ContratDao;
import com.example.demo.dao.TacheDao;
import com.example.demo.entities.Contrat;
import com.example.demo.entities.Tache;
import com.example.demo.service.facade.ContratService;
import com.example.demo.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContratServiceImplementation implements ContratService {
    @Autowired
    private ContratDao contratDao;

    @Override
    public void save(Contrat contrat) {
        contratDao.save(contrat);
    }

    @Override
    public void edit(Contrat contrat) {
        Contrat contrat1 = findById(contrat.getId());
        if (contrat1 != null){
            contrat1.setDateDebut(contrat.getDateDebut());
            contrat1.setDateFin(contrat.getDateFin());
            contrat1.setEmploye(contrat.getEmploye());
            contrat1.setLibelle(contrat.getLibelle());
            contrat1.setTypeContrat(contrat.getTypeContrat());
            contratDao.save(contrat1);
        }
    }

    @Override
    public void deleteById(Long id) {
        contratDao.deleteById(id);
    }

    @Override
    public Contrat findById(Long id) {
        return contratDao.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> findAll() {
        return contratDao.findAll();
    }

    @Override 
    public List<Contrat> findContratByCode(String code){
      return  contratDao.findContratByCode(code );
}

        @Override 
    public Contrat findContratByLibelle(String libelle){
      return  contratDao.findContratByLibelle(libelle );
}

        @Override 
    public Contrat findContratByDatedebut(Date dateDebut){
      return  contratDao.findContratByDateDebut(dateDebut );
}

        @Override 
    public Contrat findContratByDatefin(Date dateFin){
      return  contratDao.findContratByDateFin(dateFin );
}

    @Override
    public List<Contrat> findContratByTypeContrat(String typeContrat) {
        return contratDao.findContratByTypeContrat(typeContrat);
    }

}