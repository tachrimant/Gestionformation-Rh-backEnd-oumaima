package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.EmployeDto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.demo.entities.Employe;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {

        @Query(value = "SELECT e FROM Employe e WHERE e.cin LIKE CONCAT('%', :cin, '%')")
        public List<Employe> findEmployeByCinLike(@Param("cin") String cin);


        public Employe findEmployeByNom(String nom);

        public Employe findEmployeByPrenom(String prenom);

        public Employe findEmployeByEmail(String email);

        public Employe findEmployeByDatenaissance(Date datenaissance);

}