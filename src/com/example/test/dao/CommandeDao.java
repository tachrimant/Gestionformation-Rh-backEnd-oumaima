package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.test.entities.Commande;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
}