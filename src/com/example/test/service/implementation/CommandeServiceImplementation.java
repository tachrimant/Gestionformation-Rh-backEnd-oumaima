package com.example.test.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.service.facade.CommandeService;

import com.example.test.dao.CommandeDao;
import com.example.test.entities.Commande;

@Service
public class CommandeServiceImplementation implements CommandeService {
    @Autowired
    private CommandeDao commandeDao;

    @Override
    public void save(Commande commande) {
        commandeDao.save(commande);
    }

    @Override
    public void edit(Commande commande) {
        commandeDao.save(commande);
    }

    @Override
    public void deleteById(Long id) {
        commandeDao.deleteById(id);
    }

    @Override
    public Commande findById(Long id) {
        return commandeDao.findById(id).orElse(null);
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }
}