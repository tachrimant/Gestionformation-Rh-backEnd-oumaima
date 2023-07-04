package com.example.test.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.service.facade.ProduitService;

import com.example.test.dao.ProduitDao;
import com.example.test.entities.Produit;

@Service
public class ProduitServiceImplementation implements ProduitService {
    @Autowired
    private ProduitDao produitDao;

    @Override
    public void save(Produit produit) {
        produitDao.save(produit);
    }

    @Override
    public void edit(Produit produit) {
        produitDao.save(produit);
    }

    @Override
    public void deleteById(Long id) {
        produitDao.deleteById(id);
    }

    @Override
    public Produit findById(Long id) {
        return produitDao.findById(id).orElse(null);
    }

    @Override
    public List<Produit> findAll() {
        return produitDao.findAll();
    }
}