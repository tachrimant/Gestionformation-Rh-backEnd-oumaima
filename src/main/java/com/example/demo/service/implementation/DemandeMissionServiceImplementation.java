package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.dto.DemandeMissionDto;

import com.example.demo.entities.EtatDemandeMission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.facade.DemandeMissionService;

import com.example.demo.dao.DemandeMissionDao;
import com.example.demo.entities.DemandeMission;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class DemandeMissionServiceImplementation implements DemandeMissionService {
    @Autowired
    private DemandeMissionDao demandemissionDao;

    @Override
    public void save(DemandeMission demandemission) {
        demandemissionDao.save(demandemission);
    }

    @Override
    public void edit(DemandeMission demandemission) {
        DemandeMission demandeMission = findById(demandemission.getId());
        if (demandeMission != null){
            demandeMission.setDateDebut(demandemission.getDateDebut());
            demandeMission.setDateFin(demandemission.getDateFin());
            demandeMission.setEmployee(demandemission.getEmployee());
            demandeMission.setEtat(demandemission.getEtat());
            demandeMission.setLibelle(demandemission.getLibelle());
            demandemissionDao.save(demandemission);
        }
    }

    @Override
    public void deleteById(Long id) {
        demandemissionDao.deleteById(id);
    }

    @Override
    public DemandeMission findById(Long id) {
        return demandemissionDao.findById(id).orElse(null);
    }

    @Override
    public List<DemandeMission> findAll() {
        return demandemissionDao.findAll();
    }

    @Override 
    public DemandeMission findDemandeMissionByCode(String code){
      return  demandemissionDao.findDemandeMissionByCode(code );
}

        @Override 
    public DemandeMission findDemandeMissionByLibelle(String libelle){
      return  demandemissionDao.findDemandeMissionByLibelle(libelle );
}

        @Override 
    public DemandeMission findDemandeMissionByDatedebut(Date dateDebut){
      return  demandemissionDao.findDemandeMissionByDateDebut(dateDebut );
}

        @Override 
    public DemandeMission findDemandeMissionByDatefin(Date dateFin){
      return  demandemissionDao.findDemandeMissionByDateFin(dateFin );
}

        @Override 
    public DemandeMission findDemandeMissionByEtat(String etat){
      return  demandemissionDao.findDemandeMissionByEtat(etat);
}

    @Override
    public List<DemandeMission> findDemandeMissionByEMployeId(Long id) {
        return demandemissionDao.findDemandeMissionByEmployeId(id);
    }

    @Override
    public List<DemandeMission> findDemandeMissionByEmployeIdAndLibelle(Long id, String libelle) {
        return demandemissionDao.findDemandeMissionByEmployeIdAndLibelle(id,libelle);
    }

}