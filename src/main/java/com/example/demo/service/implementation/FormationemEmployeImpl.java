package com.example.demo.service.implementation;


import com.example.demo.dao.FormationEmployeDao;
import com.example.demo.entities.FormationemEmploye;
import com.example.demo.service.facade.FormationEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationemEmployeImpl implements FormationEmployeService {

    @Autowired
    private FormationEmployeDao formationEmployeDao;



    @Override
    public void save(FormationemEmploye formationemEmploye) throws Exception {
        if (formationEmployeDao.findFormationemEmployeByEmployeIdAndFormationId(formationemEmploye.getEmploye().getId(),formationemEmploye.getFormation().getId()) != null)
            throw new Exception("vous avez deja une inscription dans cet formation");
        formationEmployeDao.save(formationemEmploye);
    }

    @Override
    public void edit(FormationemEmploye formationemEmploye) {
            FormationemEmploye formationemEmploye1 = findById(formationemEmploye.getId());
            if (formationemEmploye1 != null){
                formationemEmploye1.setEmploye(formationemEmploye.getEmploye());
                formationemEmploye1.setFormation(formationemEmploye.getFormation());
                formationEmployeDao.save(formationemEmploye1);
            }
    }

    @Override
    public void deleteById(Long id) {
        formationEmployeDao.deleteById(id);
    }

    @Override
    public FormationemEmploye findById(Long id) {
        return formationEmployeDao.findById(id).orElse(null);
    }

    @Override
    public List<FormationemEmploye> findAll() {
        return formationEmployeDao.findAll();
    }

    @Override
    public List<FormationemEmploye> findFormationemEmployesByCode(String code) {
        return formationEmployeDao.findFormationemEmployesByCode(code);
    }

    @Override
    public List<FormationemEmploye> findFormationemEmployesByEmployeId(Long id) {
        return formationEmployeDao.findFormationemEmployesByEmployeId(id);
    }

    @Override
    public List<FormationemEmploye> findFormationemEmployesByFormationId(Long id) {
        return formationEmployeDao.findFormationemEmployesByFormationId(id);
    }
}
