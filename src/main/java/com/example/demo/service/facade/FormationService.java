package com.example.demo.service.facade;


import com.example.demo.entities.Formation;
import com.example.demo.entities.Formation;

import java.util.Date;
import java.util.List;

public interface FormationService {

    void save(Formation formation);
    void edit(Formation formation);
    void deleteById(Long id);
    Formation findById(Long id);
    List<Formation> findAll();

    public List<Formation> findFormationByCode(String code);

    public List<Formation> findFormationByTitle(String title);



}
