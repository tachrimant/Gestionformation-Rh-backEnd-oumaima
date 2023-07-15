package com.example.demo.dao;


import com.example.demo.entities.Formation;
import com.example.demo.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FormationDao extends JpaRepository<Formation, Long> {

    public List<Formation> findFormationsByCode(String code);

    @Query(value = "SELECT f FROM Formation f WHERE f.description LIKE CONCAT('%', :description, '%')")
    public List<Formation> findFormationsByDescription(String description);

    @Query(value = "SELECT f FROM Formation f WHERE f.title LIKE CONCAT('%', :title, '%')")
    public List<Formation> findFormationsBytitle(String title);


}
