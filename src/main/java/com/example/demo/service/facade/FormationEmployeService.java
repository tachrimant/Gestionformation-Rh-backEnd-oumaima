package com.example.demo.service.facade;

import com.example.demo.entities.FormationemEmploye;
import com.example.demo.entities.Tache;

import java.util.List;

public interface FormationEmployeService {

    void save(FormationemEmploye formationemEmploye) throws Exception;
    void edit(FormationemEmploye formationemEmploye);
    void deleteById(Long id);
    FormationemEmploye findById(Long id);
    List<FormationemEmploye> findAll();
    List<FormationemEmploye> findFormationemEmployesByCode(String code);
    List<FormationemEmploye> findFormationemEmployesByEmployeId(Long id);
    List<FormationemEmploye> findFormationemEmployesByFormationId(Long id);
}
