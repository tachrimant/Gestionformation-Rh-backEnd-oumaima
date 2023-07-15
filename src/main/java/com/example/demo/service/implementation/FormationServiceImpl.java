package com.example.demo.service.implementation;

import com.example.demo.dao.FormationDao;
import com.example.demo.entities.Formation;
import com.example.demo.service.facade.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FormationServiceImpl implements FormationService {

    @Autowired
    private FormationDao formationDao;


    @Override
    public void save(Formation formation) {
        formationDao.save(formation);

    }

    @Override
    public void edit(Formation formation) {

        Formation formation1 = findById(formation.getId());
        if (formation1 != null){
            formation1.setCode(formation.getCode());
            formation1.setTitle(formation.getTitle());
            formation1.setDateDebut(formation.getDateDebut());
            formation1.setDateFin(formation.getDateFin());
            formation1.setDescription(formation.getDescription());
            formationDao.save(formation1);
        }
    }

    @Override
    public void deleteById(Long id) {

        formationDao.deleteById(id);

    }

    @Override
    public Formation findById(Long id) {
        return formationDao.findById(id).orElse(null);
    }

    @Override
    public List<Formation> findAll() {
        return formationDao.findAll();
    }

    @Override
    public List<Formation> findFormationByCode(String code) {
        return formationDao.findFormationsByCode(code);
    }

    @Override
    public List<Formation> findFormationByTitle(String title) {
        return formationDao.findFormationsBytitle(title);
    }


}
