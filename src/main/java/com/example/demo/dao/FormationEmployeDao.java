package com.example.demo.dao;


import com.example.demo.entities.Formation;
import com.example.demo.entities.FormationemEmploye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationEmployeDao extends JpaRepository<FormationemEmploye, Long> {

    public List<FormationemEmploye> findFormationemEmployesByCode(String code);

    public List<FormationemEmploye> findFormationemEmployesByEmployeId(Long id);

    public List<FormationemEmploye> findFormationemEmployesByFormationId(Long id);

    public FormationemEmploye findFormationemEmployeByEmployeIdAndFormationId(Long employeId, Long formationId);

}
